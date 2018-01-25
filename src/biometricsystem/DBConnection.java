/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anuradha
 */
public class DBConnection{
    private static Connection con;
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:BIODB;create = true;";
   
    
    private DBConnection() throws ClassNotFoundException 
    {
        initConnection();
    }
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException
    {
        if(con == null){
            new DBConnection();
            createTable();
        }
        return con;
        
    }
    public void initConnection() throws ClassNotFoundException
    {
        try {
            Class.forName(DRIVER);
            con=DriverManager.getConnection(JDBC_URL);
            System.out.println("DB conected");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
   
    public static void createTable() throws SQLException{
       
        Statement stmt=con.createStatement();
        if(!con.getMetaData().getSchemas().next())
        {
            stmt.execute("create schema BIODB");
        }
        if(!con.getMetaData().getTables(null, null, "USERS", null).next())
        {
        con.createStatement().execute("CREATE TABLE USERS(ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1),USERNAME VARCHAR(20) NOT NULL)");
        System.out.println("table users cretaed");
        }
        if(!con.getMetaData().getTables(null, null, "USERPROFILES", null).next())
        {
        con.createStatement().execute("CREATE TABLE USERPROFILES(ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1),USERID INT NOT NULL REFERENCES USERS(ID),MEANTIME DOUBLE NOT NULL)");
        System.out.println("table userprofiles cretaed");
        
        }
    
    }

   
}

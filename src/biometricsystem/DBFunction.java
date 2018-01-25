/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author Anuradha
 */
public class DBFunction {
    
    
    public static boolean validateUsername(String username) throws SQLException, ClassNotFoundException{
        Connection con = DBConnection.getDBConnection();
	ResultSet result =null;
	System.out.println("function called");
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM USERS WHERE USERNAME=?");
        stmt.setString(1,username);
        result = stmt.executeQuery();
        
        if (result.next()){
            return false;
        }
        else{
            return true;
        }
    }
   
    public static void insertUser(User user) throws ClassNotFoundException, SQLException{
        Connection con = DBConnection.getDBConnection();
        System.out.println("insert function is calling");
        PreparedStatement stmt=con.prepareStatement("INSERT INTO USERS (USERNAME) values (?)");
        stmt.setString(1,user.getUsername());
        stmt.executeUpdate();
        System.out.println("New user details are added");
    }
    
    public static void getUserData(User user) throws SQLException, ClassNotFoundException{
        Connection con = DBConnection.getDBConnection();
	ResultSet result =null;
	System.out.println("function called");
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM USERS WHERE USERNAME=?");
        stmt.setString(1,user.getUsername());
        result = stmt.executeQuery(); 
    }
    
   
}

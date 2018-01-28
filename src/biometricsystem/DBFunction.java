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
import java.util.ArrayList;

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
   
    public static void insertUser(User user,ArrayList<Double> meantime) throws ClassNotFoundException, SQLException{
        Connection con = DBConnection.getDBConnection();
        System.out.println("insert function is calling");
        PreparedStatement stmt=con.prepareStatement("INSERT INTO USERS (USERNAME) values (?)");
        stmt.setString(1,user.getUsername());
        System.out.println("New user details are added to user account");
        stmt.executeUpdate();
        
        ResultSet result=null;
        PreparedStatement stmt1 = con.prepareStatement("SELECT ID,USERNAME FROM USERS WHERE USERNAME=?");
        System.out.println(user.getUsername());
        stmt1.setString(1,user.getUsername());
        result = stmt1.executeQuery();
        while(result.next()){
        int uID=result.getInt("ID");
        System.out.println(uID);
    
            for(int j = 0 ; j < meantime.size(); j++){
            double time=meantime.get(j);
            PreparedStatement stmtt=con.prepareStatement("INSERT INTO USERPROFILES (USERID,MEANTIME) values (?,?)");
            stmtt.setInt(1,uID);
            stmtt.setDouble(2,time);
            stmtt.executeUpdate();
            System.out.println("mean time inserted to table");
            }
        }
    }
    
    public static ArrayList<Double> getUserData(User user) throws SQLException, ClassNotFoundException{
        Connection con = DBConnection.getDBConnection();
	ResultSet result =null;
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM USERS WHERE USERNAME=?");
        stmt.setString(1,user.getUsername());
        result = stmt.executeQuery(); 
        ArrayList<Double> retrievedata=new ArrayList<>();
        if(result.next()){
            int UID=result.getInt("ID");
            System.out.println(UID);
            ResultSet rs=null;
            PreparedStatement stat = con.prepareStatement("SELECT MEANTIME FROM USERPROFILES WHERE USERID=?");
            stat.setInt(1,UID);
            rs = stat.executeQuery(); 
            System.out.println("Trying to print meantimes");
            while(rs.next()){
                //System.out.println(rs.getInt("ID"));
                retrievedata.add(rs.getDouble(1));
                System.out.println(rs.getDouble(1));
            }
            
        }
        return retrievedata;
    }
    
 
}

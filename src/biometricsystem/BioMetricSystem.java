/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricsystem;
import GUI.LandingForm;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Anuradha
 */
public class BioMetricSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        LandingForm landingform=new LandingForm();
        landingform.setVisible(true);
        DBConnection.getDBConnection();        
    }  
}

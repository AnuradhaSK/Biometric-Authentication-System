/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricsystem;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anuradha
 */
public class VerifyHandler {
    
    public boolean verifypattern(User user,ArrayList<Double> signindata) throws SQLException, ClassNotFoundException{
        System.out.println("Come to verify");
        int match=0;
        ArrayList<Double> storeddata=DBFunction.getUserData(user);
        for(int j = 0 ; j < storeddata.size(); j++){
            System.out.println(signindata.get(j)+" , "+storeddata.get(j));
            if(signindata.get(j)<storeddata.get(j)+20 && signindata.get(j)>storeddata.get(j)-20 ){
                match++;
            }
	}
        System.out.println("matches"+match);
        System.out.println("Tot count"+storeddata.size());
        float x=match;
        System.out.println(x/storeddata.size());
        if(x/storeddata.size()>0.5){
            return true;
        }else{
            return false;
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.util;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sameat.data.UserDB;

/**
 *
 * @author RomanPlt
 */
public class Validation {

    public static boolean sendMessage(String fname, String email, String message) {
        
        return !(fname==null || fname.isEmpty() || email==null || email.isEmpty() 
            || message==null || message.isEmpty());
    }

    public static boolean newUser(String fname, String lname, String id, String bday, String add, String city, String phone, String email, String usern, String password) {
        
        return !(fname==null || fname.isEmpty() || lname==null || lname.isEmpty()
                || id==null || id.isEmpty() || bday==null || bday.isEmpty() ||
                add==null || add.isEmpty() || city==null || city.isEmpty() ||
                phone==null || phone.isEmpty() || email==null || email.isEmpty()
                || usern==null || usern.isEmpty() || password==null || password.isEmpty());
    }
    
    public static boolean update(String addr , String city , String phone , String email) {
        
        return !(addr==null || addr.isEmpty() || city==null || city.isEmpty()
                || phone==null || phone.isEmpty() || email==null || email.isEmpty());
    }
    
    public static int Login(String uid , String uname , String upass) {
        
        ArrayList<String> data=new ArrayList<>();
        ArrayList<String> user;
        data.add(0 , uid);
        data.add(1 , uname);
        user=UserDB.getData(data);
        
        switch (user.get(0)) {
            case "Error2":
                return -1;
            case "Error1":
                return 0;
        }
        
        try {
            String inputhash=PasswordUtil.hashAndSaltPassword(upass, user.get(1));
            String chash=user.get(0);
            if(inputhash.equals(chash)) {
                return 1;
            }
            return 0;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
            return -2;
        }
                
    }
    
    public static int Course(String cName , String cDescr , float cPrice) {        
        if ("".equals(cName) || "".equals(cDescr) || cPrice<=0)
            return 0; //One of the paramaters is wrong
        return 1; // Good parameters                
    }
    
    
}

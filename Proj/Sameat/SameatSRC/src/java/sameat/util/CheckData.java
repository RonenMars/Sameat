package sameat.util;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import sameat.data.UserDB;



/**
 *
 * 
 */
public class  CheckData {
    
    public CheckData(){
        
    }
    
    public boolean checkID(String id) {
        return id.length() == 9;
    }
    
    public boolean checkBDay(String bday) {
        
        SimpleDateFormat dFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date userBD, minD, maxD;
        
        try {
            minD=dFormat.parse("01/01/1997");
            maxD=dFormat.parse("01/01/1935");
            userBD=dFormat.parse(bday);
             if(userBD.after(minD)|| userBD.before((maxD))){
                 return false;
                 
            }
        } catch (ParseException ex) {
            return false;
            
        }
        
        return true;
    }

    public boolean checkPasswordStrength(String password) {
       
        if(password==null || password.trim().isEmpty())
            return false;
        else if(password.length()< 8 )
            return false;
        return true;
    }
    
    public int checkLogin (String username , String userid , String password) {
        
        String[] data={userid , username};
        
        String[] result=UserDB.getData(data);
        if(result==null)
            return 0; //The Username or/and the ID wrong!
        else {
            //get Hashed Password
            try {
                String hashedPass=PasswordUtil.hashAndSaltPassword(password, result[1]);
                if(result[0].equals(hashedPass))
                    return 1; //Success
                else
                    return 0; //Failure: Wrong password.
            } catch(NoSuchAlgorithmException ex) {
                System.err.println(ex);
                return -1; // Failure: NosuchAlgorithmException 
            }
        }
    }
}

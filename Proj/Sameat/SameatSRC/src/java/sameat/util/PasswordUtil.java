
package sameat.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Base64;

public class PasswordUtil {
    
    public static String hashPassword(String password)
              throws NoSuchAlgorithmException {
        
        MessageDigest md=MessageDigest.getInstance("SHA-256");
        md.reset();
        md.update(password.getBytes());
        byte[] mdArray=md.digest();
        StringBuilder sb =new StringBuilder(mdArray.length * 2);
        for (byte b: mdArray) {
            int v=b & 0xff;
            if(v<16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }
    
    public static String getSalt() {
        
        Random r = new SecureRandom();
        byte[] saltBytes=new byte[32];
        r.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
    public static String hashAndSaltPassword(String password , String salt) 
            throws NoSuchAlgorithmException {
        
        return hashPassword(password+salt);
    }
    
   /* public static void main(String[] args) {
        try {
            String salt=getSalt();
            String hashPass=hashAndSaltPassword("fthrones5!E" , salt);
            System.out.println("Random Salt:" + salt);
            System.out.println("Hashed And Salted Password:" +hashPass);
            System.out.println("Salt Length:"+salt.length() + " Hash length:"+hashPass.length());
        } catch(NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
    }*/
}

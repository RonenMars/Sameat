
package sameat.util;

import javax.mail.MessagingException;
import sameat.business.User;

/**
 *
 * @author RomanPlt
 */
public class SendEmail {
    public static void contactUs(String fname , String email , String message) {
        
        String to="sameatsce@gmail.com";
        String from="sameatsce@gmail.com";
        String subject="Contact Us";
        String body="Full Name: "+fname+"\n"
                +"Email: "+email+"\n"
                +"The Message : \n\n"+message;
        boolean isBodyHTML=false;
        try {
            MailUtil.sendMail(to, from, subject, body, isBodyHTML);
        } catch (MessagingException ex) {
           System.err.printf(
                "Unable to send email. \n" +
                "You may need to configure your system as " +
                "described in chapter 15. \n" +
                "Here is the email you tried to send: \n" +
                "=====================================\n" +
                "TO: " + to + "\n" +
                "FROM: " + from + "\n" +
                "SUBJECT: " + subject + "\n" +
                "\n" +
                body + "\n\n");
        }
    }
    public static void newUser(User user) {
        
        String to=user.getUserEmail();
        String from="sameatsce@gmail.com";
        String subject=user.getFirstName() + " welcome to Sameat!";
        String body="Dear Customer we are very happy to welcome you to our family , \n"
                + " we hope you will enjoy from our best courses and the best and fastest service.\n\n"+
                "Your Information:\n\n"+
                "Full Name: "+user.getFirstName()+" "+user.getLastName()+"\n"
                +"ID: "+user.getUserID()+"\n"+
                "Gender: "+user.getUserGender()+"\n"
                +"Birthday: "+user.getUserBDay()+"\n"
                +"Address: "+user.getUserAddress()+" , "+user.getUserCity()+"\n"
                +"Phone: "+user.getUserPhone()+"\n"
                +"Email: "+user.getUserEmail()+"\n\n"
                +"Thank you , Sameat Team!";
        boolean isBodyHTML=false;
        try {
            MailUtil.sendMail(to, from, subject, body, isBodyHTML);
        } catch (MessagingException ex) {
           System.err.printf(
                "Unable to send email. \n" +
                "You may need to configure your system as " +
                "described in chapter 15. \n" +
                "Here is the email you tried to send: \n" +
                "=====================================\n" +
                "TO: " + to + "\n" +
                "FROM: " + from + "\n" +
                "SUBJECT: " + subject + "\n" +
                "\n" +
                body + "\n\n");
        }
    }
}

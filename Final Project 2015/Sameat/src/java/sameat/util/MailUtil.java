/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil {
    
    public static void sendMail(String to , String from ,
            String subject , String body , boolean bodyIsHTML) throws MessagingException {
        
        final String username="sameatsce@gmail.com";
        final String password="gon7fugal~trv";
        
        Properties props=new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host" , "smtp.gmail.com");
        props.put("mail.smtp.port" , "587");
       
        Session session=Session.getInstance(props, 
                new javax.mail.Authenticator() { 
                   @Override
                   protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(username , password);
                   }
                });
        session.setDebug(true);
        
        Message message=new MimeMessage(session);
        message.setSubject(subject);
        if(bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }
        
       Address fromAddress=new InternetAddress(from);
       Address toAddress=new  InternetAddress(to);
       message.setFrom(fromAddress);
       message.setRecipient(Message.RecipientType.TO, toAddress);
       
       Transport.send(message);
    }
}


package sameat.business;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class User implements Serializable {
    
    private String uID;
    private String fName;
    private String lName;
    private int uGender;
    private Date uBDay;
    private String uAddr;
    private String uCity;
    private String uPhone;
    private String uEmail;
    private String uName;
    private int uType;
    
    public User() {
        
    }
    
    public User(String userID , String firstN , String lastN , int userG , String userBDay ,
            String userA , String userC , String userP , String userE , 
            String userN , int userT) {
        
       this.uID=userID;
       this.fName=firstN;
       this.lName=lastN;
       this.uGender=userG;
       this.uBDay=stringToDate(userBDay);
       this.uAddr=userA;
       this.uCity=userC;
       this.uPhone=userP;
       this.uEmail=userE;
       this.uName=userN;
       this.uType=userT;
        
    } 
    
    public void setUserID(String userID) {
        this.uID=userID;
    }
    
    public String getUserID() {
        return uID;
    }
    
    public void setFirstName(String firstN) {
        this.fName=firstN;
    }
    
    public String getFirstName() {
        return fName;
    }
    
    public void setLastName(String lastN) {
        this.lName=lastN;
    }
    
    public String getLastName() {
        return lName;
    }
    
    public void setUserGender(int userG) {
        this.uGender=userG;
    }
    public String getUserGender() {
        
        if(this.uGender==1) {
            return "Female";
        }
        else {
            return "Male";
        }
    }
    public void setUserBDay(Date userBDay) {
        this.uBDay=userBDay;
    }
            
    public void setUserBDay(String userBDay) {
        
        /*The Birthday String in format : dd/mm/yyyy*/
        
        SimpleDateFormat dFormat=new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            
            Date userBD=dFormat.parse(userBDay);
            this.uBDay=userBD;
            
        } catch (Exception e) { 
        }
    }
    

    public String getUserBDay() {
        
      SimpleDateFormat dFormat=new SimpleDateFormat("dd/MM/yyyy");
        
      return dFormat.format(this.uBDay);
    }
    
    public void setUserAddress(String userA) {
        this.uAddr=userA;
    }
    
    public String getUserAddress() {
        return uAddr;
    }
    
    public void setUserCity(String userC) {
        this.uCity=userC;
    }
    
    public String getUserCity() {
        return uCity;
    }
    
    public void setUserPhone(String userP) {
        this.uPhone=userP;
    }
    
    public String getUserPhone() {
        return uPhone;
    }
    
    public void setUserEmail(String userE) {
        this.uEmail=userE;
    }
    
    public String getUserEmail() {
        return uEmail;
    }
    
    public void setUserName(String userN) {
        this.uName=userN;
    }
    
    public String getUserName() {
        return uName;
    }
    
    public void setUserType(int userT) {
         this.uType=userT;
    }
    
    public int getUserType() {
        return uType;
    }

    private Date stringToDate(String userBDay) { 
       
        /*The Birthday String in format : dd/mm/yyyy*/
        
        SimpleDateFormat dFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date userBD=null;
        
        try {
           
           userBD=dFormat.parse(userBDay);
            
            
        } catch (Exception e) {
        }
        
        return userBD;
    }
    
    
}


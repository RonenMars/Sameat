/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat1;

/**
 *
 * @author liron
 */
public class Person {
    
    private String  id;
    private String fName;
    private String  lName;
    private String  gender;
    private String  bDay;
    private String  addr;
    private String  phone;
    private String  email;
    private String  uName;
    private String  uPass;
    private int permition;
    private boolean isActive;
    
    
    /*
     * Constructor for Person Class
     */
    public Person(String id, String fName, String lName, String gender, String bDay, String addr, String phone, String email, String uName, String uPass, int permition, boolean isActive) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.bDay = bDay;
        this.addr = addr;
        this.phone = phone;
        this.email = email;
        this.uName = uName;
        this.uPass = uPass;
        this.permition = permition;
        this.isActive = isActive;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the bDay
     */
    public String getbDay() {
        return bDay;
    }

    /**
     * @param bDay the bDay to set
     */
    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    /**
     * @return the addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * @param addr the addr to set
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the uName
     */
    public String getuName() {
        return uName;
    }

    /**
     * @param uName the uName to set
     */
    public void setuName(String uName) {
        this.uName = uName;
    }

    /**
     * @return the uPass
     */
    public String getuPass() {
        return uPass;
    }

    /**
     * @param uPass the uPass to set
     */
    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    /**
     * @return the permition
     */
    public int getPermition() {
        return permition;
    }

    /**
     * @param permition the permition to set
     */
    public void setPermition(int permition) {
        this.permition = permition;
    }

    /**
     * @return the isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
}

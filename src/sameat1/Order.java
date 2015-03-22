/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liron
 */
public class Order {
    
    private String ordID;
    private String custID;
    private List <Course> courses = new ArrayList<Course>();
    private int amount;

    public Order(String ordID, String custID, List<Course> courses, int amount) {
        this.ordID = ordID;
        this.custID = custID;
        this.courses = courses;
        this.amount = amount;
    }

    /**
     * @return the ordID
     */
    public String getOrdID() {
        return ordID;
    }

    /**
     * @param ordID the ordID to set
     */
    public void setOrdID(String ordID) {
        this.ordID = ordID;
    }

    /**
     * @return the custID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the courses
     */
    public List <Course> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(List <Course> courses) {
        this.courses = courses;
    }
    
}

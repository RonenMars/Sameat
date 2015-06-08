
package sameat.business;

import java.io.Serializable;

public class Course implements Serializable{
    
    private int id;
    private String name;
    private String desc;
    private float price;
    private int rating;
    private boolean isInMenu;
    private boolean isActive;
    
    public Course() {
        
    }
    
    public Course(int id , String name , String desc , float price) {
        this.id=id;
        this.name=name;
        this.desc=desc;
        this.price=price;
    }
    
     public Course(int id , String name , String desc , float price, 
                                        boolean isInMenu, boolean IsActive) {
        this.id=id;
        this.name=name;
        this.desc=desc;
        this.price=price;
        this.isInMenu=isInMenu;
        this.isActive=IsActive;
    }
    
    public void setId(int id) {
        this.id=id;
    }
    public int getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
       return this.name;
    }
    
    public void setDesc(String desc) {
        this.desc=desc;
    }
    public String getDesc() {
        return this.desc;
    }
    
    
    public void setPrice(float price) {
        this.price=price;
    }
    public float getPrice() {
        return this.price;
    }
    
    public int getRating() {
        return this.rating;
    }
    
    public void setRating(int rating) {
        this.rating=rating;
    }
    
     public void setisInMenu(boolean isMenu) { 
        this.isInMenu=isMenu;
    }
    public boolean getisInMenu() {
        return this.isInMenu;
    }
    
    public void setIsActive(boolean isActive) {
        this.isActive=isActive;
    }
    
    public boolean getIsActive() {
        return this.isActive;
    }
    
}

package sameat.business;

import java.io.Serializable;

public class Ingredient implements Serializable{
    
    private int id;
    private String name;
    private float price;
    private int inventory;
    
    public Ingredient() { };
    
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
    
    public void setPrice(float price) {
        this.price=price;
    }
    
    public float getPrice() {
        return this.price;
    }
    
    public void setInventory(int inventory) {
        this.inventory=inventory;
    }
    
    public int getInventory() {
        return this.inventory;
    }

}


package sameat.business;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    
    private int id;
    private String customerId;
    private String orderDate;
    private int isRated;
    private float price;
    private ArrayList<Item> items;
    
    public Order() {
        this.items=new ArrayList<>();
    }
    
    public ArrayList<Item> getItems() {
        return this.items;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id=id;
    }
    
    public String getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(String custid) {
        this.customerId=custid;
    }
    
    public String getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(String ordate) {
        this.orderDate=ordate;
    }
    
    public float getPrice() {
        return this.price;
    }
    
    public void setPrice(float price) {
        this.price=price;
    }
    
    public int getIsRated() {
        return this.isRated;
    }
    
    public void setIsRated(int r) {
        this.isRated=r;
    }
    
    public int getCount() {
        return this.items.size();
    }
    
    public void addItem(Item item) {
        int cid=item.getCourse().getId();
        int quantity=item.getQuantity();
        for (Item itm : this.items) {
           if(itm.getCourse().getId()==cid) {
               itm.setQuantity(quantity);
               return;
           }
        }
        this.items.add(item);
    }
    
    public void removeItem(Item item) {
        int cid=item.getCourse().getId();
        for (Item itm : this.items) {
            if(itm.getCourse().getId()==cid) {
                this.items.remove(itm);
                return;
            }
        }
    }  
}

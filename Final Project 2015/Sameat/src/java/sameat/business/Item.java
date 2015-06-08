
package sameat.business;

import java.io.Serializable;

public class Item implements Serializable {
    
    private Course course;
    private int quantity;
    
    public Item() {}
        
    public void setCourse(Course c) {
        this.course=c;
    }
    
    public Course getCourse() {
        return this.course;
    }
    
    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public double getTotal() {
        double total=course.getPrice() * this.quantity;
        return total;
    }
    
}

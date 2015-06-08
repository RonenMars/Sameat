
package sameat.business;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable{
    
    private ArrayList<Item> items;
    
    public Cart() {
        this.items=new ArrayList<>();
    }
    
    public ArrayList<Item> getItems() {
        return this.items;
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

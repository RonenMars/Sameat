
package sameat.business;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author RomanPlt
 */
public class Course_Ingredients implements Serializable{
    
    private Course course;
    private ArrayList<Ingredient> ingredients;
    
     public Course_Ingredients() {
        this.ingredients=new ArrayList<>();
    }
    
    public void setCourse(Course course) {
        this.course=course;
    }
    
    public Course getCourse() {
        return this.course;
    }
   
    
    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }
    
    public int getCount() {
        return this.ingredients.size();
    }
    
    public void addIngredient(Ingredient ingredient) {
        int ingid=ingredient.getId();
        for (Ingredient i : this.ingredients) {
            if(i.getId()==ingid) {
                return;
            }
        }
        this.ingredients.add(ingredient);
    }
    
    public void removeIngredient(Ingredient ingredient) {
        int ingid=ingredient.getId();
        for(Ingredient i : this.ingredients) {
            if(i.getId()==ingid) {
                this.ingredients.remove(i);
                return;
            }
        }
    }
}

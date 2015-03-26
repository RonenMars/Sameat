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
public class Storage {
    
    private List < Ingredient > ingredients = new ArrayList<Ingredient>();;

    public Storage(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    

    /**
     * @return the ingredients
     */
    public List < Ingredient > getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(List < Ingredient > ingredients) {
        this.ingredients = ingredients;
    }
    
    
}

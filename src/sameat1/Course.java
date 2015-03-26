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
public class Course {
    
    private String cID;
    private String cName;
    private int cPrice;
    private List< Ingredient >  ingredients = new ArrayList<Ingredient>();
    private String imgLink;
    private float rating;

    public Course(String cID, String cName, int cPrice, String imgLink, float rating, List< Ingredient >  ingredients ) {
        this.cID = cID;
        this.cName = cName;
        this.cPrice = cPrice;
        this.imgLink = imgLink;
        this.rating = rating;
        this.ingredients = ingredients;
    }


  
    /**
     * @return the cID
     */
    public String getcID() {
        return cID;
    }

    /**
     * @param cID the cID to set
     */
    public void setcID(String cID) {
        this.cID = cID;
    }

    /**
     * @return the cName
     */
    public String getcName() {
        return cName;
    }

    /**
     * @param cName the cName to set
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

    /**
     * @param cPrice the cPrice to set
     */
    public void setcPrice(int cPrice) {
        this.cPrice = cPrice;
    }

    /**
     * @param imgLink the imgLink to set
     */
    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    /**
     * @return the rating
     */
    public float getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * @return the cPrice
     */
    public int getcPrice() {
        return cPrice;
    }

    /**
     * @return the ingredients
     */
    public List< Ingredient > getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(List< Ingredient > ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * @return the imgLink
     */
    public String getImgLink() {
        return imgLink;
    }
    
    
}

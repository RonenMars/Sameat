/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.business;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 *
 * @author matan_naman
 */

public class Products implements Serializable {

    public Products(String ProductName, String pricePer100g, String pricePerUnit, String AmoutOfProduct, String IsInMenu) {
        this.ProductName = ProductName;
        this.pricePer100g = pricePer100g;
        this.pricePerUnit = pricePerUnit;
        this.AmoutOfProduct = AmoutOfProduct;
        this.IsInMenu = IsInMenu;
    }

    public String getIsInMenu() {
        return IsInMenu;
    }

    public void setIsInMenu(String IsInMenu) {
        this.IsInMenu = IsInMenu;
    }
    private String ProductName;
    private String pricePer100g;
    private String pricePerUnit;
    private String AmoutOfProduct;
     private String IsInMenu;
    
    public Products(){
        
    }

    /**
     * @return the ProductName
     */
    public String getProductName() {
        return ProductName;
    }

    /**
     * @param ProductName the ProductName to set
     */
    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    /**
     * @return the pricePer100g
     */
    public String getPricePer100g() {
        return pricePer100g;
    }

    /**
     * @param pricePer100g the pricePer100g to set
     */
    public void setPricePer100g(String pricePer100g) {
        this.pricePer100g = pricePer100g;
    }

    /**
     * @return the pricePerUnit
     */
    public String getPricePerUnit() {
        return pricePerUnit;
    }

    /**
     * @param pricePerUnit the pricePerUnit to set
     */
    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    /**
     * @return the AmoutOfProduct
     */
    public String getAmoutOfProduct() {
        return AmoutOfProduct;
    }

    /**
     * @param AmoutOfProduct the AmoutOfProduct to set
     */
    public void setAmoutOfProduct(String AmoutOfProduct) {
        this.AmoutOfProduct = AmoutOfProduct;
    }
    
    
}
    


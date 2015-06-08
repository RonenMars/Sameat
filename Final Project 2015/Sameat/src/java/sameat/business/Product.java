/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.business;

/**
 *
 * @author liron
 */
public class Product {
     private String ProductName;
      private int AmoutOfProduct;

    public Product(String ProductName, int AmoutOfProduct) {
        this.ProductName = ProductName;
        this.AmoutOfProduct = AmoutOfProduct;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getAmoutOfProduct() {
        return AmoutOfProduct;
    }

    public void setAmoutOfProduct(int AmoutOfProduct) {
        this.AmoutOfProduct = AmoutOfProduct;
    }
      
      
}
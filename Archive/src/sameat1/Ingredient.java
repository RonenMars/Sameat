/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat1;

/**
 *
 * @author liron
 */
public class Ingredient {
    
    private String iID;
    private String IName;
    private float iAmount;
    private float iPrice;
    private float iMinAmount;

    public Ingredient(String iID, String IName, float iAmount, float iPrice, float iMinAmount) {
        this.iID = iID;
        this.IName = IName;
        this.iAmount = iAmount;
        this.iPrice = iPrice;
        this.iMinAmount = iMinAmount;
    }
    
    /**
     * @return the iID
     */
    public String getiID() {
        return iID;
    }

    /**
     * @param iID the iID to set
     */
    public void setiID(String iID) {
        this.iID = iID;
    }

    /**
     * @return the IName
     */
    public String getIName() {
        return IName;
    }

    /**
     * @param IName the IName to set
     */
    public void setIName(String IName) {
        this.IName = IName;
    }

    /**
     * @return the iAmount
     */
    public float getiAmount() {
        return iAmount;
    }

    /**
     * @param iAmount the iAmount to set
     */
    public void setiAmount(float iAmount) {
        this.iAmount = iAmount;
    }

    /**
     * @return the iPrice
     */
    public float getiPrice() {
        return iPrice;
    }

    /**
     * @param iPrice the iPrice to set
     */
    public void setiPrice(float iPrice) {
        this.iPrice = iPrice;
    }

    /**
     * @return the iMinAmount
     */
    public float getiMinAmount() {
        return iMinAmount;
    }

    /**
     * @param iMinAmount the iMinAmount to set
     */
    public void setiMinAmount(float iMinAmount) {
        this.iMinAmount = iMinAmount;
    }
    
    
}

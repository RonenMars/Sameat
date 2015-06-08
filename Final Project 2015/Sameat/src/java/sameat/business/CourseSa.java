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
public class CourseSa {

    public CourseSa(String cName, String cDescription, float cPrice, String cIsInMenu) {
        this.cName = cName;
        this.cDescription = cDescription;
        this.cPrice = cPrice;
        this.cIsInMenu = cIsInMenu;
    }
    private String cName;
    private String cDescription;
    private float cPrice;
    private String cIsInMenu;

    public CourseSa() {
        
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public float getcPrice() {
        return cPrice;
    }

    public void setcPrice(float cPrice) {
        this.cPrice = cPrice;
    }

    public String getcIsInMenu() {
        return cIsInMenu;
    }

    public void setcIsInMenu(String cIsInMenu) {
        this.cIsInMenu = cIsInMenu;
    }
    
}

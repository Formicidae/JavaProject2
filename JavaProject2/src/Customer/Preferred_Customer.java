/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

/**
 *
 * @author Eddie
 */
public class Preferred_Customer extends Customer {
    private double discount;
    
    Preferred_Customer(String f, String l, double i, double s, double p){
        super(f,l,i,s);
        discount = p;
    }
    
    public Preferred_Customer(Customer c){
        super(c.getfName(),c.getlName(),c.getID(),c.getSpent());
        discount = 0;
    }
    
    public Preferred_Customer(){
        super();
        discount = 0;
    }
    
    

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    
}

package javaproject2;

/**
 *
 * @author Eddie
 */
public class Customer {
    private String fName;
    private String lName;
    private double ID;
    private double spent;
    
    Customer(String f, String l, double i, double s){
        fName = f;
        lName = l;
        ID = i;
        spent = s;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the ID
     */
    public double getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(double ID) {
        this.ID = ID;
    }

    /**
     * @return the spent
     */
    public double getSpent() {
        return spent;
    }

    /**
     * @param spent the spent to set
     */
    public void setSpent(double spent) {
        this.spent = spent;
    }
    
    
}

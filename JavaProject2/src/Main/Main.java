/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.io.*;
import Customer.Customer;
import Customer.Preferred_Customer;
import java.util.*;

/**
 *
 * @author Eddie
 */
public class Main {

    public static Customer[] Customs = new Customer[0];
    public static Preferred_Customer[] Preferred = new Preferred_Customer[0];
    
    
    public static void main(String[] args) throws IOException{

        //preferred file opening and adding to array
        try {
            File Fprefers = new File("preferred.dat");
            Scanner Sprefers = new Scanner(Fprefers);
            while(Sprefers.hasNextLine()){
		Preferred = addCustomerP(Preferred,LineToCustP(Sprefers.nextLine()));
            }
            Sprefers.close();
        } catch (IOException e) {
             // complain to user
             System.out.println("File not found" + e);
        }
        
        // customers.dat file opening and adding to array
        try {
            File Fcustomers = new File("customers.dat");
            //Customer[] Customs = new Customer[0];
            Scanner Scustom = new Scanner(Fcustomers);
            while(Scustom.hasNextLine()){
		Customs = addCustomer(Customs,LineToCust(Scustom.nextLine()));
            }
            Scustom.close();
        } catch (IOException e) {
             // complain to user
             System.out.println("File not found" + e);
        }
        
        //orders.dat file opening abd buying with each line
        try {
            File FOrders = new File("orders.dat");
            Scanner sc = new Scanner(FOrders);
            while(sc.hasNextLine()){
                buy(sc.nextDouble(),drinkPrice(sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble()));     
            }
            sc.close();
        } catch (IOException e) {
             // complain to user
             System.out.println("File not found" + e);
        }
        
        //Opens preferred for output and prints array
        File FprefersO = new File("preferred.dat");
 
	OutputStream POut = new FileOutputStream(FprefersO);
        
        for(Preferred_Customer p: Preferred){
            String line = printP(p);
            for(int i = 0;i < line.length();i++){
                POut.write(line.charAt(i));
            }

        }
        POut.close();
        
        //Opens customers for output and prints array
        File FcustO = new File("customers.dat");
 
	OutputStream cOut = new FileOutputStream(FcustO);
        
        for(Customer c: Customs){
            String line = printC(c);
            for(int i = 0;i < line.length();i++){
                cOut.write(line.charAt(i));
            }

        }
        
        cOut.close();
  
    }
    
    public static Customer LineToCust(String s){
        Customer c1 = new Customer();
        
        //Gets each part of the line
        Scanner st = new Scanner(s);
        c1.setID(st.nextDouble());
        c1.setfName(st.next());
        c1.setlName(st.next());
        c1.setSpent(st.nextDouble());
        if(st.hasNext()){
            Preferred_Customer p1 = new Preferred_Customer(c1);
            p1.setDiscount(st.nextDouble());
            return p1;
        }
        return c1;
    }
    
    public static Preferred_Customer LineToCustP(String s){
        //Takes line and converts it into a preferred_customer
        Preferred_Customer c1 = new Preferred_Customer();
        Scanner st = new Scanner(s);
        c1.setID(st.nextDouble());
        c1.setfName(st.next());
        c1.setlName(st.next());
        c1.setSpent(st.nextDouble());
        String dis = st.next();
        c1.setDiscount(Integer.parseInt(dis.substring(0,dis.length()-1)) / 100);

        return c1;
    }
    
    public static Preferred_Customer[] addCustomer(Customer[] arr1,Customer cust){
        //makes a new customer array one longer than the other and adds all elements plus the new one
        Preferred_Customer[] arr2 = new Preferred_Customer[arr1.length + 1];
        
        for(int i = 0;i < arr1.length;i++){
            arr2[i] = new Preferred_Customer(arr1[i]);
        }
        arr2[arr2.length - 1] = new Preferred_Customer(cust);
        return arr2;
    }
    
    public static Preferred_Customer[] addCustomerP(Preferred_Customer[] arr1,Preferred_Customer cust){
        //makes a new preferred_customer array one longer than the other and adds all elements plus the new one
        Preferred_Customer[] arr2 = new Preferred_Customer[arr1.length + 1];
        
        for(int i = 0;i < arr1.length;i++){
            arr2[i] = arr1[i];
        }
        arr2[arr2.length - 1] = cust;
        return arr2;
    }
    
    public static double drinkPrice(double r, double h, double o, double op, double sip, double quan){
        //Uses elements of cylinder to get surafce area and calculate cost
	Double price =  ((2 * Math.PI * r * h) + (r * r * Math.PI * 2)) * sip;
	price += o * op;
	return price * quan;
    }
    
    public static Customer[] removeCust(int index,Customer[] c){
        //Removes given customer
        Customer[] c1 = new Customer[c.length - 1];
        int skipped = 0;
        for(int i = 0; i < c.length;i++){
            System.out.println(c[i].getID());
            if(i != index){
                c1[i-skipped] = c[i];
            }
            else{
                System.out.println("        " + c[i].getID());
                skipped = 1;
            }
        }
        return c1;
    }
    
    public static Preferred_Customer[] removeCustP(int index,Preferred_Customer[] c){
        //Removes given preferred_customer
        Preferred_Customer[] c1 = new Preferred_Customer[c.length - 1];
        int skipped = 0;
        for(int i = 0; i < c.length;i++){
            if(i != index){
                c1[i-skipped] = c[i];
            }
            else{
                skipped = 1;
            }
        }
        return c1;
    }
    
    public static int findc(double id, Customer[] c){
        //Finds customer
        for(int i = 0; i < c.length;i++){
            if(c[i].getID() == id){
                return i;
            }
        }
        return -1;
    }
    
    public static int findp(double id, Preferred_Customer[] c){
        //Finds a preferred_Customer
        for(int i = 0; i < c.length;i++){
            if(c[i].getID() == id){
                return i;
            }
        }
        return -1;
    }
    
    public static void buy(double id, double price){
        //Finds the customer or preferred with id given
        int index = findc(id,Customs);
        if(index == -1){
            index = findp(id,Preferred);
            if(index == -1){
                System.out.println("ID not found");
                return;
            }
            //Adds drink price to customer and determines of it should get a discount
            Preferred[index].setSpent((price - (price * Preferred[index].getDiscount())) + Preferred[index].getSpent());
            if(Preferred[index].getSpent() >= 200.0){
                Preferred[index].setDiscount(.07);
            }
            if(Preferred[index].getSpent() >= 350){
                Preferred[index].setDiscount(.1);
            }
        }
        else{
            //Adds drink price to preferred_customer and determines of it should get a discount
            Customs[index].setSpent(price + Customs[index].getSpent());
            if(Customs[index].getSpent() >= 150){
                System.out.println("moveing to prefer");
                Preferred = addCustomer(Preferred, Customs[index]);
                Customs = removeCust(index, Customs);
                index = (int)findp(id,Preferred);
                System.out.println("Discount id: " + Preferred[index].getID());
                Preferred[index].setDiscount(.05);
                if(Preferred[index].getSpent() >= 200){
                    Preferred[index].setDiscount(.07);
                }
                if(Preferred[index].getSpent() >= 350){
                    Preferred[index].setDiscount(.1);
                }
                System.out.println("Discount amount: " + Preferred[index].getDiscount());
            }
        }
        
    }
    
    public static String printP(Preferred_Customer c){
        //Prints formated preferred_customer
        return (int)c.getID() + " " + c.getfName() + " " + c.getlName() + " " + c.getSpent() + " " + (int)(100 * c.getDiscount()) + "%\n";
    }
    
    public static String printC(Customer c){
        //Prints formated customer
        return (int)c.getID() + " " + c.getfName() + " " + c.getlName() + " " + c.getSpent() + "\n";
    }
    
    
    
}

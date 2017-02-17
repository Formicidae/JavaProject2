/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

/**
 *
 * @author Eddie
 */
public class TimeClock extends MilTime{
    String endMil;
    int endSeconds;
    
    public TimeClock(int h,int m,int s,int eh,int em,int es){
        super.Time(h,m,s);
        endMil = ((Integer)eh).toString() + ((Integer)em).toString();
        endSeconds = es;  
    }
    
    public int TimeDifference(){
        return ((int)(endMil.charAt(1)) + (10*((int)(endMil.charAt(0))))) - super.hour;
    }
    
}

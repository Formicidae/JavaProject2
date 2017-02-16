/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

/**
 *
 * @author Eddie
 */
public class MilTime extends Time{
    int milHours;
    
    
    
    
    @Override
    public int getHour(){
        return milHours;
    }
    
    @Override
    public void setHour(int h){
        milHours = h;
    }
    
    public MilTime(int mil, int s){
        
    }
    
    
}

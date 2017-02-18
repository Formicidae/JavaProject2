/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

import time.Time;

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
    
    public MilTime(Integer mil, int s){
        if(mil > 2359){
            mil = 2359;
            hour = (int)((mil.toString()).charAt(1)) + (10*((int)((mil.toString()).charAt(0))));
            minutes = (int)((mil.toString()).charAt(3)) + (10*((int)((mil.toString()).charAt(2))));
            seconds = s;
        }
        else if((mil%100) > 60){
            mil = 60;
            hour = (int)((mil.toString()).charAt(1)) + (10*((int)((mil.toString()).charAt(0))));
            minutes = (int)((mil.toString()).charAt(3)) + (10*((int)((mil.toString()).charAt(2))));
            seconds = s;
        }
        else if(mil < 0){
            mil = 0;
            hour = (int)((mil.toString()).charAt(1)) + (10*((int)((mil.toString()).charAt(0))));
            minutes = (int)((mil.toString()).charAt(3)) + (10*((int)((mil.toString()).charAt(2))));
            seconds = s;
        }
    }
    
    public void setTime(Integer mil, int s){
        if(mil > 2359){
            mil = 2359;
            hour = (int)((mil.toString()).charAt(1)) + (10*((int)((mil.toString()).charAt(0))));
            minutes = (int)((mil.toString()).charAt(3)) + (10*((int)((mil.toString()).charAt(2))));
            seconds = s;
        }
        else if((mil%100) > 60){
            mil = 60;
            hour = (int)((mil.toString()).charAt(1)) + (10*((int)((mil.toString()).charAt(0))));
            minutes = (int)((mil.toString()).charAt(3)) + (10*((int)((mil.toString()).charAt(2))));
            seconds = s;
        }
        else if(mil < 0){
            mil = 0;
            hour = (int)((mil.toString()).charAt(1)) + (10*((int)((mil.toString()).charAt(0))));
            minutes = (int)((mil.toString()).charAt(3)) + (10*((int)((mil.toString()).charAt(2))));
            seconds = s;
        }  
    }
    
    public int getStandHr(){
        return super.getHour();
    }
    
}

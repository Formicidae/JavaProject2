
package time;

import time.Time;

/**
 *
 * @author Eddie emb160030
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
    
    public MilTime(MilTime m){
        this.milHours = m.milHours;
        this.hour = m.hour;
    }
    
    public MilTime(String mil, int s){
        milHours = Integer.parseInt(mil);
        if(Integer.parseInt(mil) > 2359){
            mil = "2359";
            hour = Integer.parseInt(mil.substring(1,2)) +  (10* Integer.parseInt(mil.substring(0,1)));
            minutes = Integer.parseInt(mil.substring(3,4)) +  (10* Integer.parseInt(mil.substring(2,3)));
            seconds = s;
        }
        else if(Integer.parseInt(mil) < 0){
            hour = 0;
            minutes = 0;
            seconds = s;
        }
        else if((Integer.parseInt(mil)%100) > 60){
            hour = Integer.parseInt(mil.substring(1,2)) +  (10* Integer.parseInt(mil.substring(0,1)));
            minutes = 60;
            seconds = s;
        }
        else{
            hour = Integer.parseInt(mil.substring(1,2)) +  (10* Integer.parseInt(mil.substring(0,1)));
            minutes = Integer.parseInt(mil.substring(3,4)) +  (10* Integer.parseInt(mil.substring(2,3)));
            seconds = s;
        }
    }
    
    public void setTime(String mil, int s){
        milHours = Integer.parseInt(mil);
        if(Integer.parseInt(mil) > 2359){
            mil = "2359";
            hour = Integer.parseInt(mil.substring(1,2)) +  (10* Integer.parseInt(mil.substring(0,1)));
            minutes = Integer.parseInt(mil.substring(3,4)) +  (10* Integer.parseInt(mil.substring(2,3)));
            seconds = s;
        }
        else if(Integer.parseInt(mil) < 0){
            hour = 0;
            minutes = 0;
            seconds = s;
        }
        else if((Integer.parseInt(mil)%100) > 60){
            hour = Integer.parseInt(mil.substring(1,2)) +  (10* Integer.parseInt(mil.substring(0,1)));
            minutes = 60;
            seconds = s;
        }
        else{
            hour = Integer.parseInt(mil.substring(1,2)) +  (10 * Integer.parseInt(mil.substring(0,1)));
            minutes = Integer.parseInt(mil.substring(3,4)) +  (10 * Integer.parseInt(mil.substring(2,3)));
            seconds = s;
        } 
    }
    
    public int getStandHr(){
        return super.getHour();
    }
    
}

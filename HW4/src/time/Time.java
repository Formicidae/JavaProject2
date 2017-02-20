
package time;

public abstract class Time {
    int hour;
    int minutes;
    int seconds;
    
    public Time(){
        hour = 0;
        minutes = 0;
        seconds = 0;
    }
    
    public Time(int h,int m,int s){
        hour = h;
        minutes = m;
        seconds = s;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
  
}

package hw4;
import time.*;

/**
 * @author Eddie emb160030
 */
public class HW4 {

    public static void main(String[] args) {
        MilTime m = new MilTime("0522", 33);
        MilTime e = new MilTime("1205", 36);
        TimeClock t = new TimeClock(m,e);
        System.out.println(t.TimeDifference());
        
        MilTime tl = new MilTime("0755", 2);
        m.setTime("1506", 45);
        TimeClock rt = new TimeClock(tl,m);
        System.out.println(rt.TimeDifference());
        
    } 
}

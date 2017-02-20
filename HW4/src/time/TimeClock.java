package time;

/**
 * @author Eddie emb160030
 */
public class TimeClock extends MilTime{
    public MilTime mil;
    public int endSeconds;
    
    public TimeClock(MilTime start,MilTime end){
        super(start);
        mil = end; 
    }
    
    public int TimeDifference(){
        return (getMil().getStandHr() - super.hour);
    }

    public MilTime getMil() {
        return mil;
    }

    public void setMil(MilTime mil) {
        this.mil = mil;
    }

    public int getEndSeconds() {
        return endSeconds;
    }

    public void setEndSeconds(int endSeconds) {
        this.endSeconds = endSeconds;
    }
    
}

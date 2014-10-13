package fontys.time;

/**
 * Implementation class of IPeriod interface.
 * @author Etienne [B2]
 */
public class Period implements IPeriod {

    //<editor-fold defaultstate="collapsed" desc="Fields.">
    
    private ITime beginTime;
    private ITime endTime;
     
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods.">
    
    /**
     * Creates a new IPeriod implementation with begin time bt and end time et
     * @param bt begin time bt must be earlier than end time et
     * @param et
     */
    public Period(ITime bt, ITime et) {
        if (bt.compareTo(et) > 0){
            throw new IllegalArgumentException("beginTime must be earlier than endTime!");
        }
        
        this.beginTime = bt;
        this.endTime = et;
    }        
    
    /**
     * Returns the time this period begins.
     * @return an ITime object of the begintime of this period.
     */
    @Override
    public ITime getBeginTime() {
        // This returns a copy of beginTime, preventing setting the property.
        // For more info about references and mutability, read this:
        // http://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
        ITime time = this.beginTime;
        return time;
    }

    /**
     * Returns the time this period ended. 
     * @return an ITime object of the endtime of this period.
     */
    @Override
    public ITime getEndTime() {
        ITime time = this.endTime;
        return time;
    }

    /**
     * Return the length of the period.
     * @return Returns an integer of the length in minutes.
     */
    @Override
    public int length() {
        return this.beginTime.difference(endTime);
    }
    
    /**
     * Sets the begintime of this period.
     * @param beginTime an ITime object with a time set before the endtime of this period.
     */
    @Override
    public void setBeginTime(ITime beginTime) {
        if (beginTime.compareTo(endTime) > 0)
            throw new IllegalArgumentException("beginTime can't be after endTime!");
        this.beginTime = beginTime;
    }

    /**
     * Sets the endtime of this period.
     * @param endTime an ITime object with a time set after the begintime of this period.
     */
    @Override
    public void setEndTime(ITime endTime) {
        if (endTime.compareTo(beginTime) < 0)
            throw new IllegalArgumentException("endTime can't be before beginTime!");
        this.endTime = endTime;
    }

    /**
     * Moves the period a given amount of minutes.
     * @param minutes an integer indicating the time in minutes. 
     * A negative amount moves the period back.
     */
    @Override
    public void move(int minutes) {                                                
        beginTime = beginTime.plus(minutes);
        endTime = endTime.plus(minutes);
    }

    /**
     * Changes the length of the period.
     * @param minutes An integer that represents the amount of minutes to change the length with.
     * Negative values are allowed.
     */
    @Override
    public void changeLengthWith(int minutes) {
        if (minutes < 0 && minutes > length()) {
            throw new IllegalArgumentException("Can't move back past the begin!");
        }
        endTime.plus(minutes);
    }

    /**
     * Determines whether a period is part of another period.
     * @param period a IPeriod object that encapsulates the child.
     * @return true if all moments within this period are included within [period], 
     * otherwise false
     */
    @Override
    public boolean isPartOf(IPeriod period) {
        // Before -1 / Same 0 / After +1
        boolean afterStart = beginTime.compareTo(period.getBeginTime()) > 0;
        boolean beforeEnd = endTime.compareTo(period.getEndTime()) < 0;
                
        if(afterStart && beforeEnd){
            return true;
        }
        
        return false;
    }

    /**
     * Returns the smallest period that is consecutive or has a common intersection 
     * with the given period.
     * @param period an IPeriod to compare with.
     * @return if this period and [period] are consecutive or possess a
     * common intersection, then the smallest period p will be returned, 
     * for which this period and [period] are part of p, 
     * otherwise null will be returned 
     */
    @Override
    public IPeriod unionWith(IPeriod period) {                
        boolean consecutive = endTime.equals(period.getBeginTime()) | beginTime.equals(period.getEndTime());
        boolean intersects = false;
        IPeriod smallest = null;
        
        if(intersectionWith(period) != null){
            intersects = true;
        }

        if (consecutive | intersects) {
            
            if (this.length() > period.length())
                smallest = period;
            else
                smallest = this;         
        }
        
        return smallest;
    }

    /**
     * Returns the largest period which is part of the given period or null if 
     * the intersection is empty.
     * @param period An IPeriod to look up the intersections of.
     * @return the largest period which is part of this period 
     * and [period] will be returned; if the intersection is empty null will 
     * be returned
     */
    @Override
    public IPeriod intersectionWith(IPeriod period) {
        IPeriod p = null;
        boolean intersects = false;
        
        if (
                //period.begintime is before this.begintime and 
                //period.endtime is after this.begintime.
                period.getBeginTime().compareTo(beginTime) <= 0 &&
                period.getEndTime().compareTo(beginTime) > 0
                |
                //period.begintime is after this.begintime, before endtime and
                //endtime is after this.begintime or endtime.
                period.getBeginTime().compareTo(beginTime) >= 0 &&
                period.getEndTime().compareTo(beginTime) > 0
            )
        {
            intersects = true;
        }
        
        //INTERSECTS: 
        //         p1, p2, p3, p4
        //      |           |
        //   ---|--p1       |
        //      |         --|---p2
        //      |  -----p3  |
        //    --|-----------|------p4
        //      |           | --p5
        //______|___________|______ time
        //      |=== p0 ====|           
        
        if (intersects) { 
            //Length is only relevant if there is an intersection.
            if (this.length() > period.length()) 
                p = this;
            else
                p = period;                                  
        }

        return p;
    }
    
    // </editor-fold>
}

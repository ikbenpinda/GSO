/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author Roel
 */
public class Period2 implements IPeriod {

    private ITime beginTime;
    private ITime endTime;
    private long duration;

    /**
     * Constructor
     *
     * @param beginTime Begin time
     * @param endTime End time
     */
    public Period2(ITime beginTime, ITime endTime) {

        if (beginTime.compareTo(endTime) == 1) {
            throw new IllegalArgumentException();
        }

        this.beginTime = beginTime;
        this.endTime = endTime;

        duration = beginTime.difference(endTime);
    }

    @Override
    public ITime getBeginTime() {
        return beginTime;
    }

    @Override
    public ITime getEndTime() {
        return endTime;
    }

    @Override
    public int length() {
        return (int) duration;
    }

    @Override
    public void setBeginTime(ITime newBeginTime) {
        if (endTime.compareTo(newBeginTime) == 1) {
            beginTime = newBeginTime;
        } else {
            throw new IllegalArgumentException("Begin time is later than end time");
        }
    }

    @Override
    public void setEndTime(ITime newEndTime) {
        if (beginTime.compareTo(newEndTime) == -1) {
            endTime = newEndTime;
            duration = beginTime.difference(endTime);
        } else {
            throw new IllegalArgumentException("Begin time is later than end time");
        }
    }

    @Override
    public void move(int minutes) {
        beginTime.plus(minutes);
        endTime.plus(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
        if ((minutes + this.length()) > 0) {
            endTime.plus(minutes);
            duration += minutes;
        } else {
            throw new IllegalArgumentException("Length can't be negative");
        }
    }

    @Override
    public boolean isPartOf(IPeriod period) {
        boolean result;

        if (beginTime.compareTo(period.getBeginTime()) == -1) {
            int periodDuration = (int) duration;

            if (beginTime.plus(periodDuration).compareTo(period.getEndTime()) == 1) {
                result = true;
            } else {
                result = false;
            }

        } else {
            result = false;
        }

        return result;
    }

    @Override
    public IPeriod unionWith(IPeriod period) {
        IPeriod result = null;

        if (period.intersectionWith(this) == this) {
            result = period;
        }

        return result;
    }

    @Override
    public IPeriod intersectionWith(IPeriod period) {
        IPeriod result;

        if (period.length() > this.length()) {
            result = period;
        } else {
            result = this;
        }

        return result;
    }

}

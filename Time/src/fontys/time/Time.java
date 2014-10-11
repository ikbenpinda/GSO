/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.GregorianCalendar;

/**
 *
 * @author Roel
 */
public class Time implements ITime {

    GregorianCalendar gregorianCalendar;

    /**
     * Constructor for Time
     *
     * @param year
     * @param month 1≤m≤12
     * @param day 1≤d≤31
     * @param hour 0≤h≤23
     * @param minute 0≤m≤59
     */
    public Time(int year, int month, int day, int hour, int minute) {
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("Month needs to be between 1 and 12");
        } else if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day needs to be between 1 and 31");
        } else if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour needs to be between 0 and 23");
        } else if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute needs to be between 0 and 59");
        } else {
            gregorianCalendar = new GregorianCalendar(year, month - 1, day, hour, minute);
        }
    }

    @Override
    public int getYear() {
        int year = gregorianCalendar.get(GregorianCalendar.YEAR);
        return year;
    }

    @Override
    public int getMonth() {
        int month = gregorianCalendar.get(GregorianCalendar.MONTH) + 1;
        return month;
    }

    @Override
    public int getDay() {
        int day = gregorianCalendar.get(GregorianCalendar.DATE);
        return day;
    }

    @Override
    public int getHours() {
        int hours = gregorianCalendar.get(GregorianCalendar.HOUR_OF_DAY);
        return hours;
    }

    @Override
    public int getMinutes() {
        int minutes = gregorianCalendar.get(GregorianCalendar.MINUTE);
        return minutes;
    }

    @Override
    public DayInWeek getDayInWeek() {
        int day = gregorianCalendar.get(GregorianCalendar.DAY_OF_WEEK);
        switch (day) {
            case 1:
                return DayInWeek.SUN;
            case 2:
                return DayInWeek.MON;
            case 3:
                return DayInWeek.TUE;
            case 4:
                return DayInWeek.WED;
            case 5:
                return DayInWeek.THU;
            case 6:
                return DayInWeek.FRI;
            case 7:
                return DayInWeek.SAT;
        }
        return null;
    }

    @Override
    public ITime plus(int minutes) {
        int year = getYear();
        int month = getMonth();
        int day = getDay();
        int hours = getHours();
        int minutes2 = getMinutes();
        Time result = new Time(getYear(), getMonth(), getDay(), getHours(), getMinutes());
        result.gregorianCalendar.add(GregorianCalendar.MINUTE, minutes);
        return result;
    }

    @Override
    public int difference(ITime time) {
        Time input = (Time) time;
        long result = 0;
        result = input.gregorianCalendar.getTimeInMillis() - this.gregorianCalendar.getTimeInMillis();
        result /= 1000; //ToSeconds
        result /= 60; //ToMinutes
        return (int) result;
    }

    @Override
    public int compareTo(ITime o) {
        int result;

        if (this.difference(o) > 0) {
            result = 1;
        }
        if (this.difference(o) < 0) {
            result = -1;
        } else {
            result = 0;
        }

        return result;
    }
}

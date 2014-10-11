/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import fontys.time.*;

/**
 * Getters worden niet getest, rest wel.
 *
 * @author Etienne [B2]
 */
public class Period2Test {
    // editor-fold comments zijn het XML-equivalent van #region/#endregion in C#.

    //<editor-fold defaultstate="collapsed" desc="Fields.">
    static Period2 period;
    static Time t1;
    static Time t2;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Unit Tests.">
    @Test
    public void PeriodTest() {
        // * @param bt begin time 'bt' must be earlier than end time 'et'.
        assertTrue("BeginTime shouldn't be later than EndTime.", period.getBeginTime().difference(period.getEndTime()) > 0);
        assertNotNull("BeginTime shouldn't be null.", period.getBeginTime());
        assertNotNull("EndTime shouldn't be null.", period.getEndTime());
    }

    @Ignore(value = "Tests preconditions, which are currently unknown.")
    @Test
    public void PreconditionTest() {

        try {//TODO
            period.setBeginTime(new Time(2014, 10, 5, 12, 15));
        } catch (IllegalArgumentException e) {
            fail("BeginTime needs to be set.");
        }

        try {//TODO
            period.setBeginTime(new Time(2014, 10, 5, 12, 15));
        } catch (IllegalArgumentException e) {
            fail("BeginTime needs to be set.");
        }

        try {//TODO
            period.setBeginTime(new Time(2014, 10, 5, 12, 15));
        } catch (IllegalArgumentException e) {
            fail("BeginTime needs to be set.");
        }

        try {//TODO
            period.setEndTime(new Time(2014, 10, 5, 12, 15));
        } catch (IllegalArgumentException e) {
            fail("EndTime needs to be set.");
        }

        try {//TODO
            period.setEndTime(new Time(2014, 10, 5, 12, 15));
        } catch (IllegalArgumentException e) {
            fail("EndTime needs to be set.");
        }

        try {//TODO
            period.setEndTime(new Time(2014, 10, 5, 12, 15));
        } catch (IllegalArgumentException e) {
            fail("EndTime needs to be set.");
        }
    }

    @Test
    public void lengthTest() {
        assertTrue("Period exceeded Integer.MAX_VALUE.", period.length() < Integer.MAX_VALUE);
        assertTrue("Period is not a positive amount of minutes.", period.length() > 0);

    }

    @Test
    public void setBeginTimeTest(/*ITime beginTime*/) {
        //* @param beginTime must be earlier than the current end time
        //* of this period
        //period.setBeginTime(beginTime);
        assertTrue("BeginTime shouldn't be later than EndTime.", period.getBeginTime().difference(period.getEndTime()) > 0);
    }

    @Test
    public void setEndTimeTest(/*ITime endTime*/) {
        //* @param endTime must be later than the current begin time
        //* of this period
        //period.setEndTime(endTime);
        assertTrue("EndTime should be later than beginTime.", period.getBeginTime().difference(period.getEndTime()) > 0);
    }

    @Test
    public void moveTest(/*int minutes*/) {
        //* @param minutes (a negative value is allowed)
        // What to test?
        //* the begin and end time of this period will be moved up both with [minutes]
        //* minutes        
        //Clone is also possible but considered badly implemented.
        //Interface for future use of mocks.
        int minutes = 80;
        IPeriod p2 = new Period(period.getBeginTime(), period.getEndTime());
        p2.move(minutes);
        assertEquals("BeginTime hasn't been moved correctly.",
                period.getBeginTime().difference(p2.getBeginTime()), minutes);
        assertEquals("EndTime hasn't been moved correctly.",
                period.getEndTime().difference(p2.getEndTime()), minutes);
    }

    @Test
    public void changeLengthWithTest(/*int minutes*/) {
        //* @param minutes  minutes + length of this period must be positive  
        int minutes = 80;
        assertTrue("Minutes is 0 or negative.", minutes > 0);
    }

    @Test
    public void isPartOfTest(/*IPeriod p*/) {
        //* @return true if all moments within this period are included within [period], 
        //* otherwise false
        IPeriod p = new Period(new Time(2014, 8, 26, 13, 37), new Time(2014, 8, 26, 16, 49));
        assertTrue("Period does not cover all moments.",
                period.getBeginTime().compareTo(p.getBeginTime()) < 0
                && period.getEndTime().compareTo(p.getEndTime()) < 0);
    }

    @Test
    public void unionWithTest(/*IPeriod p*/) {
        //* @return if this period and [period p] are consecutive or possess a
        //* common intersection, then the smallest period p will be returned, 
        //* for which this period and [period p] are part of p, 
        //* otherwise null will be returned         
        //assertEquals("", new Object(), new Object());
        //assertNull("", null);
    }

    @Test
    public void intersectionWithTest(/*IPeriod p*/) {
        //* @return the largest period which is part of this period 
        //* and [period] will be returned; if the intersection is empty null will
        //* be returned        
        //  
        //assertEquals("", new Object(), new Object());
        //assertNull("", null);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setup.">
    //-- Test Setup ------------------------------------------------------------        
    @BeforeClass
    public static void setUpClass() {
        t1 = new Time(2014, 10, 5, 12, 15);
        t2 = new Time(2014, 10, 5, 12, 45);
        period = new Period2(t1, t2);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //</editor-fold>
}

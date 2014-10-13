/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import fontys.time.*;

/**
 * Testclass for the IPeriod implementations.
 * @author Etienne [B2]
 */
public class PeriodTest {
    // editor-fold comments zijn het XML-equivalent van #region/#endregion in C#.

    //<editor-fold defaultstate="collapsed" desc="Fields.">
    
    static Period period;
    static Time t1;
    static Time t2;

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Unit Tests.">
    
    /**
     * Tests tied to the construction of a period.
     */
    @Test
    public void PeriodTest() {
        // * @param bt begin time 'bt' must be earlier than end time 'et'.
        assertTrue("BeginTime shouldn't be later than EndTime.", period.getBeginTime().difference(period.getEndTime()) > 0);
        assertNotNull("BeginTime shouldn't be null.", period.getBeginTime());
        assertNotNull("EndTime shouldn't be null.", period.getEndTime());
    }

    /**
     * Tests the correct measuring of a periods length.
     */
    @Test
    public void lengthTest() {
        Period p = new Period(new Time(2014, 8, 26, 15, 33), new Time(2014, 8, 26, 16, 33));
        assertTrue("Period is not a positive amount of minutes." + p.length(), p.length() > 0);
        assertTrue("Period does not return the right amount of minutes.", p.length() == 60);
    }

    @Test
    public void setBeginTimeTest(){
        //* @param beginTime must be earlier than the current end time
        //* of this period
        //period.setBeginTime(beginTime);
        assertTrue("BeginTime shouldn't be later than EndTime.", period.getBeginTime().difference(period.getEndTime()) > 0);
    }

    @Test
    public void setEndTimeTest() {
        //* @param endTime must be later than the current begin time
        //* of this period
        //period.setEndTime(endTime);
        assertTrue("EndTime should be later than beginTime.", period.getBeginTime().difference(period.getEndTime()) > 0);
    }

    @Test
    public void moveTest() {
        //* the begin and end time of this period will be moved up both with [minutes]
        //* minutes       
        // .Clone() is also possible but considered badly implemented.
        // Interface for future use of mocks.
        int minutes = 80;
        IPeriod p2 = new Period(period.getBeginTime(), period.getEndTime());
        p2.move(minutes);
        assertEquals("BeginTime hasn't been moved correctly.",
                period.getBeginTime().difference(p2.getBeginTime()), minutes);
        assertEquals("EndTime hasn't been moved correctly.",
                period.getEndTime().difference(p2.getEndTime()), minutes);
    }

    @Test
    public void changeLengthWithTest() {
        //* @param minutes  minutes + length of this period must be positive  
        int minutes = 90;
        IPeriod p = new Period(new Time(2014, 11, 21, 7, 0), new Time(2014, 11, 26, 8, 0));
        p.changeLengthWith(minutes);
        assertTrue("Minutes + Length() is 0 or negative.", p.length() > 0);
        IPeriod check = new Period(new Time(2014, 11, 21, 7, 0), new Time(2014, 11, 26, 9, 30));
        assertEquals("Time not set correctly.", p, check);
    }

    @Test
    public void isPartOfTest() {
        //* @return true if all moments within this period are included within [period],         
        IPeriod p1 = new Period(new Time(2012, 12, 30, 23, 59), new Time(2013, 1, 1, 12, 0));
        IPeriod p2 = new Period(new Time(2012, 8, 26, 13, 37), new Time(2014, 8, 26, 13, 37));
        assertTrue("Period does not cover all moments.", p1.isPartOf(p2));
        //* otherwise false
        assertFalse("Period p2 is not part of p1.", p2.isPartOf(p1));
    }

    @Test
    public void unionWithTest() {
        
     IPeriod p_smaller = new Period(
             new Time(2014, 11, 4, 12, 0), new Time(2014, 11, 15, 12, 0));
     IPeriod p_bigger = new Period(
             new Time(2014, 11, 12, 12, 0), new Time(2014, 11, 24, 12, 0));
     IPeriod p_null = new Period(
             new Time(2014, 1, 1, 12, 0), new Time(2014, 1, 1, 23, 59));
     
     //* @return if this period and [period] are consecutive or possess a
     //* common intersection, then the smallest period p will be returned, 
     //* for which this period and [period] are part of p, 
     assertEquals("The bigger period was returned. Or the intersection was not found.", p_smaller, p_smaller.unionWith(p_bigger));
     //* otherwise null will be returned 
     assertEquals("No null returned.", null, p_smaller.unionWith(p_null));
    }

    @Test
    public void intersectionWithTest() {
        IPeriod p1 = new Period(
                new Time(2014, 11, 4, 12, 0), new Time(2014, 11, 15, 12, 0));
        IPeriod p2 = new Period(
                new Time(2014, 11, 2, 12, 0), new Time(2014, 11, 6, 12, 0));
        
        IPeriod result = p1.intersectionWith(p2);
        IPeriod expResult = new Period(
                new Time(2014, 11, 2, 12, 0), new Time(2014, 11, 15, 12, 0));
        
        assertEquals("Periods are not intersecting.", result, expResult);
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="//-- Test Setup ------------------------------------------------------------        ">
    
    @BeforeClass
    public static void setUpClass() {
        t1 = new Time(2014, 10, 5, 12, 15);
        t2 = new Time(2014, 10, 5, 12, 45);
        period = new Period(t1, t2);
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

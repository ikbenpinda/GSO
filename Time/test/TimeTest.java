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
 *
 * @author Roel
 */
public class TimeTest {    
    
    public TimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void constructorTestMonth(){
    // @param m 1≤m≤12
        Time time = new Time(2014, 14, 3, 4, 25);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void constructorTestDay(){
    // @param d 1≤d≤31
        Time time = new Time(2014, 12, 35, 4, 25);        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void constructorTestHour(){
    // @param h 0≤h≤23
        Time time = new Time(2014, 12, 3, -3, 25);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void constructorTestMin(){
    // @param m 0≤m≤59
        Time time = new Time(2014, 12, 3, 4, 132);
    }
    
    /**
     * 
     * @param minutes (a negative value is allowed)
     * @return  this time plus minutes
     */
    @Test
    public void plusTest(){
        Time time = new Time(2014, 12, 2, 3, 5);
        time = (Time) time.plus(10);
        
        assertEquals("Wrong amount of minutes added", 15, time.getMinutes());
        
        time = new Time(2014, 12, 2, 3, 25);
        time = (Time) time.plus(-10);
        
        assertEquals("Wrong amount of minutes added", 15, time.getMinutes());
    }
    
    /**
     * 
     * @param time
     * @return the difference between this time and [time] expressed in minutes
     */
    @Test
    public void differenceTest(){
        Time time1 = new Time(2014, 12, 2, 3, 5);
        Time time2 = new Time(2014, 12, 2, 3, 15);
        
        int difference = time1.difference(time2);
        assertEquals("Wrong difference returned", 10, difference);
    }    

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
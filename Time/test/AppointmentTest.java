/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import fontys.time.Appointment;
import fontys.time.Contact;
import fontys.time.IPeriod;
import fontys.time.Period;
import fontys.time.Time;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Roel
 */
public class AppointmentTest {

    private String subject;
    private IPeriod period;
    private Appointment defaultInstance;
    private Contact contact;

    public AppointmentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        subject = "Test Subject";
        period = new Period(new Time(1995, 7, 10, 10, 24), new Time(2014, 10, 11, 11, 15));
        defaultInstance = new Appointment(subject, period);
        contact = new Contact("Roel de Wit");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSubject method
     */
    @Test
    public void testGetSubject() {
        Appointment instance = defaultInstance;
        String expected = "Test Subject";
        String result = instance.getSubject();

        assertEquals(expected, result);
    }

    /**
     * Test of getPeriod method
     */
    @Test
    public void testGetPeriod() {
        Appointment instance = defaultInstance;
        IPeriod expected = period;
        IPeriod result = instance.getPeriod();

        assertEquals(expected, result);
    }

    /**
     * Test of invitees method
     */
    @Test
    public void testinvitees() {
        Appointment instance;
        ArrayList<Contact> expectedResultList;
        Iterator<Contact> expectedResultIterator;
        Iterator<Contact> resultIterator;
        Contact expectedResult = null;
        Contact result = null;

        instance = defaultInstance;
        expectedResultIterator = null;
        resultIterator = instance.invitees();
        assertEquals(expectedResultIterator, resultIterator);

        instance.addContact(contact);
        expectedResultList = new ArrayList<Contact>();
        expectedResultList.add(contact);

        expectedResultIterator = expectedResultList.iterator();
        resultIterator = instance.invitees();
        try {
            for (int i = 0; i < expectedResultList.size(); i++) {
                for (int j = 0; j <= i; j++) {
                    expectedResult = expectedResultIterator.next();
                    result = resultIterator.next();
                }
                assertEquals(expectedResult, result);
            }
        } catch (Exception exception) {
            String message = exception.getMessage();
            fail(exception.getMessage());
        }
    }

    /**
     * Test of AddContact method
     */
    @Test
    public void testAddContact() {
        Appointment instance;
        ArrayList<Contact> expectedResultList;
        Iterator<Contact> expectedResultIterator;
        Iterator<Contact> resultIterator;
        Contact expectedResult = null;
        Contact result = null;

        instance = defaultInstance;
        instance.addContact(contact);
        expectedResultList = new ArrayList<Contact>();
        expectedResultList.add(contact);

        try {
            for (int i = 0; i < expectedResultList.size(); i++) {
                expectedResultIterator = expectedResultList.iterator();
                resultIterator = instance.invitees();
                for (int j = 0; j <= i; j++) {
                    expectedResult = expectedResultIterator.next();
                    result = resultIterator.next();
                }
                assertEquals(expectedResult, result);
            }
        } catch (Exception exception) {
            String message = exception.toString();
            fail(exception.getMessage());
        }
    }

    /**
     * Test of RemoveContact method
     */
    @Test
    public void testRemoveContact() {
        Appointment instance;
        ArrayList<Contact> expectedResultList;
        Iterator<Contact> expectedResult;
        Iterator<Contact> result;

        instance = defaultInstance;
        instance.addContact(contact);

        instance.removeContact(contact);

        expectedResult = null;
        result = instance.invitees();
        assertEquals(expectedResult, result);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Appointment class
 *
 * @author Roel
 */
public class Appointment {

    /**
     * Subject
     */
    String subject;

    /**
     * Period
     */
    IPeriod period;

    /**
     * Invitees
     */
    ArrayList<Contact> invitees;

    /**
     * Constructor
     *
     * @param subject Subject
     * @param period Period
     */
    public Appointment(String subject, IPeriod period) {
        this.subject = subject;
        this.period = period;
        invitees = new ArrayList<Contact>();
    }

    /**
     * Get subject
     *
     * @return Subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Get period
     *
     * @return Period
     */
    public IPeriod getPeriod() {
        return period;
    }

    /**
     * Get all invitees
     *
     * @return Iterator for invitees
     */
    public Iterator<Contact> invitees() {
        return invitees.iterator();
    }

    /**
     * Add a contact to the appointment
     *
     * @param contact Contact
     * @return Boolean indicating if action is successful
     */
    public boolean addContact(Contact contact) {
        boolean result = contact.addAppointment(this);

        if (result) {
            invitees.add(contact);
        }

        return result;
    }

    /**
     * Remove contact as invitee
     *
     * @param contact Contact
     */
    public void removeContact(Contact contact) {
        invitees.remove(contact);
    }
}

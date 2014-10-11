/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Roel
 */
public class Appointment {

    String subject;
    IPeriod period;
    ArrayList<Contact> invitees;

    public Appointment(String subject, IPeriod period) {
        this.subject = subject;
        this.period = period;
        invitees = new ArrayList<Contact>();
    }

    public String getSubject() {
        return subject;
    }

    public IPeriod getPeriod() {
        return period;
    }

    public Iterator<Contact> invitees() {
        return invitees.iterator();
    }

    public boolean addContact(Contact contact) {
        boolean result = contact.addAppointment(this);

        if (result) {
            invitees.add(contact);
        }
        
        return result;
    }

    public void removeContact(Contact contact) {
        invitees.remove(contact);
    }
}

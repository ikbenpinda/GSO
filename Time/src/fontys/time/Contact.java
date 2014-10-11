/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Contact class
 *
 * @author Roel
 */
public class Contact {

    /**
     * Name
     */
    String name;

    /**
     * Agenda
     */
    ArrayList<Appointment> agenda;

    /**
     * Constructor
     *
     * @param name Name
     */
    public Contact(String name) {
        this.name = name;
        agenda = new ArrayList<Appointment>();
    }

    /**
     * Get name
     *
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Add appointment to agenda
     *
     * @param appointment Appointment
     * @return Boolean indicating if action is successful
     */
    boolean addAppointment(Appointment appointment) {
        if (appointment != null) {
            for (Appointment app : agenda) {
                if (app.getPeriod().intersectionWith(appointment.getPeriod()) != null) {
                    return false;
                }
            }
            agenda.add(appointment);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove appointment from agenda
     *
     * @param appointment Appointment
     */
    void removeAppointment(Appointment appointment) {
        agenda.remove(appointment);
    }

    /**
     * Get all appointments
     *
     * @return Iterator for appointments
     */
    public Iterator<Appointment> appointments() {
        if (agenda.size() > 0) {
            return agenda.iterator();
        } else {
            return null;
        }
    }
}

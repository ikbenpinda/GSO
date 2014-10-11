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
public class Contact {

    String name;
    ArrayList<Appointment> agenda;

    public Contact(String name) {
        this.name = name;
        agenda = new ArrayList<Appointment>();
    }

    public String getName() {
        return name;
    }
    
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

    void removeAppointment(Appointment appointment) {
        agenda.remove(appointment);
    }

    public Iterator<Appointment> appointments() {
        return agenda.iterator();
    }
}

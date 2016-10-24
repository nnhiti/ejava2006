/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nus.iss.ejava.business;

import edu.nus.iss.ejava.model.People;
import edu.nus.iss.ejava.model.Appointment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PeopleManagementBean {
    
    @PersistenceContext private EntityManager em;

    public void addPeople(final People people) {
        
    }
    
    public void addAppointment(final Appointment appointment) {
        
    }
    
    public List<Appointment> findAppointmentByPeople() {
        TypedQuery<Appointment> query = em.createNamedQuery(
                        "Appointment.findAppointmentByPeople", Appointment.class);
	return (query.getResultList());
    }
}

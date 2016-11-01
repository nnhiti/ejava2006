/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nus.iss.ejava.business;

import edu.nus.iss.ejava.model.Group;
import edu.nus.iss.ejava.model.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class NoteManagementtBean {
    
    private static final String DEFAULT_ROLE = "manage";
    
    @PersistenceContext private EntityManager em;

    public void createUser(final User user) {
        em.persist(user);
        Group group = new Group();
        group.setGroupId(DEFAULT_ROLE);
        group.setUserId(user.getUserId());
        em.persist(group);
    }
    
    public User findUserById(String id) {
        return em.find(User.class, id);
    }
    
    
    
//    public void addPeople(final People people) {
//        em.persist(people);
//    }
//    
//    public People getPeopleByEmail(final String email) {
//        TypedQuery<People> query = em.createNamedQuery("People.findPeopleByEmail", People.class);
//        query.setParameter("email", email);
//        query.setHint("javax.persistence.cache.storeMode", "REFRESH");
//        List<People> lstPeople = query.getResultList();
//        if (lstPeople!=null && !lstPeople.isEmpty()) {
//            return lstPeople.get(0);
//        }
//	return null;
//    }
//    
//    public boolean isPeopleExist(final String email) {
//        People people = getPeopleByEmail(email);
//	return (people!=null);
//    }
//    
//    public void addAppointment(final Appointment appointment) {
//        em.persist(appointment);
//    }
//    
//    public List<Appointment> findAppointmentByPeople(String email) {
//        People people = getPeopleByEmail(email);
//        if (people != null) {
//            return people.getLstAppointment();
//        }
//        
//        return null;
//    }
}

package com.etroya.database;

import com.etroya.model.Profile;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Created by Adam on 2015-06-21.
 */
public class HibernateUtil {
    public static void main (String[] args){
        Profile profile = new Profile();
        profile.setProfileName("Epredator");
        profile.setId(1L);
        profile.setFirstName("Adam");
        profile.setLastName("Sasa");

        org.hibernate.SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();
        session.beginTransaction();
        session.save(profile);
        session.getTransaction().commit();
    }
}

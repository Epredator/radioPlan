package com.etroya.database;

import com.etroya.model.Profile;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by Adam on 2015-06-21.
 */
public class HibernateUtil {
    public static void main (String[] args){
        Profile profile = new Profile();
        profile.setProfileName("Stefan");
        profile.setId(1L);
        profile.setFirstName("Stefan");
        profile.setLastName("Zabłyński");
        profile.setDescription("This is my new account");
        profile.setEmail("a@etroya.pl");
        profile.setJoindedDate(new Date());

        org.hibernate.SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();
        session.beginTransaction();
        session.save(profile);
        session.getTransaction().commit();
        session.close();
        profile = null;
        session =sessionFactory.openSession();
        session.beginTransaction();
        profile = (Profile) session.get(Profile.class, 1L);
        System.out.println("Profile name retrived is " + profile.getProfileName());
    }
}

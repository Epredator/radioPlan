package com.etroya.database;


import com.etroya.model.Profile;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


/**
 * Created by Adam on 2015-07-04.
 */
public class SessionCreator {
    public static void main(String[] args){
        Profile user = new Profile();
//        user.setProfileName("UgaBu");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        session.save(user);
        Profile prof = (Profile) session.get(Profile.class, 1L);
        session.getTransaction().commit();
        session.close();

        prof.setProfileName("BuUName -updated user name after session close");

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(prof);
        session.getTransaction().commit();
        session.close();
    }
}

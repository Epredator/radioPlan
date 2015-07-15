package com.etroya.database;

import com.etroya.model.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Adam on 2015-07-11.
 */
public class dbFirstLvlCache {
    public static void main(String[] aggs){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Profile profile = (Profile) session.get(Profile.class, 1L);
        profile.setLastName("Wacanowski");

        session.getTransaction().commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Profile profile2 = (Profile) session2.get(Profile.class, 1L);
        session2.getTransaction().commit();
        session2.close();
    }
}

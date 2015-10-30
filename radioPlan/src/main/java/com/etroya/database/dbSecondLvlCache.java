package com.etroya.database;

import com.etroya.model.Profile;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Adam on 2015-07-11.
 */
public class dbSecondLvlCache {
    public static void main(String[] aggs){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Profile profile where id = 1");
        query.setCacheable(true);
        List users = query.list();

        Profile profile = (Profile) session.get(Profile.class, 1L);
        profile.setLastName("Wacanowski");

        session.getTransaction().commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Profile profile2 = (Profile) session2.get(Profile.class, 1L);

        Query query2 = session2.createQuery("from Profile profile where id = 1");
        query2.setCacheable(true);
        List users2 = query2.list();




        session2.getTransaction().commit();
        session2.close();
    }
}

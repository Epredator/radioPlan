package com.etroya.database;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.List;

/**
 * Created by Adam on 2015-07-16.
 */
public class DBsecondLvlCacheFetchSample {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Profile profile where id = 1");
        query.setCacheable(true);
        List users = query.list();

        session.getTransaction().commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();

        Query query2 = session2.createQuery("from Profile profile where id = 1");
        query.setCacheable(true);
        List users2 = query2.list();

        session2.getTransaction().commit();
        session2.close();
    }
}

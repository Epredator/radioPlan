package com.etroya.database;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Adam on 2015-07-07.
 */
public class dbHQLsampler {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Profile where id > 5");
        List users = query.list();


//        session.save();
        session.getTransaction().commit();
        session.close();
        System.out.println("Size of user list:" + users.size() );
    }
}

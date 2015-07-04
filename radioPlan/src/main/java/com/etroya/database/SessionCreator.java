package com.etroya.database;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


/**
 * Created by Adam on 2015-07-04.
 */
public class SessionCreator {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        session.getTransaction().commit();
        session.close();
    }
}

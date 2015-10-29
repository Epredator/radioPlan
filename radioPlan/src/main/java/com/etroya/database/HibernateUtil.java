package com.etroya.database;

import com.etroya.model.*;
import org.eclipse.persistence.sessions.factories.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by Adam on 2015-06-21.
 */
public class HibernateUtil {
    public static void main (String[] args){

        org.hibernate.SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();
        session.beginTransaction();

        session.getTransaction().commit();
        session.close();

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
    }
}

package com.etroya.database;

import com.etroya.model.Profile;
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
        Query query = session.createQuery("select new map(id, profileName)  from Profile");
//        Query queryOtherSample = session.createQuery("select max(profileName)  from Profile");
        query.setFirstResult(5);
        query.setMaxResults(4); //maximum number of records (use this to paginate)
        List<String> profileNames = (List<String>) query.list();
        session.getTransaction().commit();
        session.close();

        for (String p : profileNames)
            System.out.println(p);
    }
}

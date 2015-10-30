package com.etroya.database;

import com.etroya.model.Profile;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Adam on 2015-07-09.
 */
public class dbHQLpaginateSampler {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String minProfileId = "5";
        String lastName = "9Botlowski";
        Query query = session.getNamedQuery("Profile.byId");
        query.setInteger(0, Integer.parseInt(minProfileId));
//        query.setString("setLastName", lastName);

        List<Profile> profiles = (List<Profile>) query.list();
        session.getTransaction().commit();
        session.close();

        for(Profile p : profiles){
            System.out.println(p.getLastName());
        }



    }
}

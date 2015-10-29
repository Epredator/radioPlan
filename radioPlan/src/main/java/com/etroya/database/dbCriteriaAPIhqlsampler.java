package com.etroya.database;

import com.etroya.model.Profile;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import java.util.List;

/**
 * Created by Adam on 2015-07-10.
 */
public class dbCriteriaAPIhqlsampler {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        Criteria criteria = session.createCriteria(Profile.class);
//        criteria.add(Restrictions.or(
//                Restrictions.like("profileName", "%Botlowski%"),
//                Restrictions.gt("id", 5L)
//                )
//        );
//        Criteria criteria = session.createCriteria(Profile.class)
//                .setProjection(Projections.property("userId")); //pobieranie jedynie kolumny które chcemy a nie całego obiektu

//        Criteria criteria = session.createCriteria(Profile.class)
//                .setProjection(Projections.max("userId"));

//        Criteria criteria = session.createCriteria(Profile.class)
//                .setProjection(Projections.count("userId"));

//        Criteria criteria = session.createCriteria(Profile.class)
//                .addOrder(Order.desc("id"));

        Profile exampleProfile = new Profile();
        exampleProfile.setProfileName("Botlowski");
        Example example = Example.create(exampleProfile).enableLike();


        Criteria criteria = session.createCriteria(Profile.class)
                .add(example);


        List<Profile> profiles = (List<Profile>) criteria.list();
        session.getTransaction().commit();
        session.close();

        for (Profile p : profiles)
            System.out.println(p.getProfileName());



    }
}

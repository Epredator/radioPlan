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
        Profile profile = new Profile();
        profile.setProfileName("Stefan");
        profile.setFirstName("Stefan");
        profile.setLastName("Zabłyński");
        profile.setDescription("This is my new account");
        profile.setEmail("a@etroya.pl");
        profile.setJoindedDate(new Date());

        Address addr = new Address();
        addr.setCity("Warsaw");
        addr.setStreet("Francuska");
        addr.setCountry("Poland");
        addr.setCode("00-001");

        Address addr2 = new Address();
        addr2.setCity("Cracow");
        addr2.setStreet("Gdańska");
        addr2.setCountry("Poland");
        addr2.setCode("00-002");

        profile.getListOfAddresses().add(addr);
        profile.getListOfAddresses().add(addr2);

        org.hibernate.SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();
        session.beginTransaction();
        session.save(profile);
        session.getTransaction().commit();
        session.close();
        profile = null;
        session =sessionFactory.openSession();
        session.beginTransaction();
        profile = (Profile) session.get(Profile.class, 1L);
        System.out.println("Profile name retrived is " + profile.getProfileName());

        session.close();

        session = sessionFactory.openSession();
        profile = (Profile) session.get(Profile.class, 1L);
        System.out.println(profile.getListOfAddresses().size());
        session.close();
        session = sessionFactory.openSession();
        session.beginTransaction();
        Station station = new Station();
        Program program = new Program();
        Program program2 = new Program();

        station.setName("Polskie Radio Czwórka");
        program.setName("Podsiadówka");
        program2.setName("Numer raz na fali");
        station.getPrograms().add(program);
        station.getPrograms().add(program2);
        program.setStation(station);
        station.getProfiles().add(profile);
        program.getProfiles().add(profile);

        Advertisement advert1 = new Advertisement();
        advert1.setName("Colgate advertisement");
        advert1.setStation(station);
        advert1.setProducer("Colgate");
        advert1.setProductName("Colgate");


        session.persist(station);
        session.persist(program);
        session.save(advert1);
        session.getTransaction().commit();
        session.close();
    }
}

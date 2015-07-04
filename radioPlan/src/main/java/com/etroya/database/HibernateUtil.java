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
        Profile prof1 = new Profile();
        prof1.setProfileName("Stefan");
        prof1.setFirstName("Stefan");
        prof1.setLastName("Zabłyński");
        prof1.setDescription("This is my new account");
        prof1.setEmail("a@etroya.pl");
        prof1.setJoindedDate(new Date());

        Profile prof2 = new Profile();
        prof2.setProfileName("MaJa");
        prof2.setFirstName("Maurycy");
        prof2.setLastName("Jarząbek");
        prof2.setDescription("Jestem Jarząbek");
        prof2.setEmail("maurycy@etroya.pl");
        prof2.setJoindedDate(new Date());





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

        prof2.getListOfAddresses().add(addr);
        prof2.getListOfAddresses().add(addr2);

        org.hibernate.SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();
        session.beginTransaction();
        session.save(prof1);
        session.save(prof2);
        session.getTransaction().commit();
        session.close();
        prof2 = null;
        session =sessionFactory.openSession();
        session.beginTransaction();
        for(int i =0; i<10; i++){
            Profile profI = new Profile();
            profI.setProfileName("Botlowski" + i);
            profI.setLastName(i+ "Botlowski");
            session.save(profI);

        }
        session.getTransaction().commit();
        prof2 = (Profile) session.get(Profile.class, 1L);
        System.out.println("Profile name retrived is " + prof2.getProfileName());

        session.close();

        session = sessionFactory.openSession();
        prof2 = (Profile) session.get(Profile.class, 1L);
        System.out.println(prof2.getListOfAddresses().size());
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
        station.getProfiles().add(prof2);
        program.getProfiles().add(prof2);

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

        session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(advert1);
        station.setName("Zmieniona nazwa");
        session.update(station);
        session.getTransaction().commit();
        session.close();
    }
}

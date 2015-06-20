package com.etroya.hibernate;


import com.etroya.hibernate.domain.Event;
import com.etroya.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by Adam on 2015-06-20.
 */
public class EventManager {public static void main(String[] args) {
    EventManager mgr = new EventManager();
        mgr.createAndStoreEvent("My Event", new Date());
    HibernateUtil.getSessionFactory().close();
}

    private void createAndStoreEvent(String title, Date theDate) {
        Session session = null;
        try {
             session = HibernateUtil.getSessionFactory().getCurrentSession();
        }catch (org.hibernate.HibernateException he) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setId(1L);
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);

        session.getTransaction().commit();
    }

}

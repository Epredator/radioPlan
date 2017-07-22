package com.etroya.radioplan.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.print.Book;

/**
 * Created by eperedator on 22.07.17.
 */
public class StationRepository {

    @PersistenceContext(unitName = "stationStorePU")
    EntityManager em;

    public Book find(Long id){
        return em.find(Book.class, id);

    }

    public Book create(Book book){
        em.persist(book);
        return book;

    }


    public void delete(Long id){
        em.remove(em.getReference(Book.class, id));

    }
}

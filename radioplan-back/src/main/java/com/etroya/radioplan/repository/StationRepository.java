package com.etroya.radioplan.repository;

import com.etroya.radioplan.model.Station;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.awt.print.Book;
import java.util.List;

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

    public List<Station> findAll(){
        TypedQuery<Station> query = em.createQuery("SELECT s FROM Station s ORDER BY s.title DESC", Station.class);
        return query.getResultList();
    }

    public Long countAll(){
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(s) FROM Station s", Long.class);
        return query.getSingleResult();
    }
}

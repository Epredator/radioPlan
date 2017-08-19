package com.etroya.radioplan.repository;

import com.etroya.radioplan.model.Station;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.awt.print.Book;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

/**
 * Created by eperedator on 22.07.17.
 */
@Transactional(SUPPORTS)
public class StationRepository {

    @PersistenceContext(unitName = "stationStorePU")
    EntityManager em;


    public Book find(@NotNull @Min(10)Long id){
        return em.find(Book.class, id);

    }

    @Transactional(REQUIRED)
    public Book create(@NotNull Book book){
        em.persist(book);
        return book;

    }

    @Transactional(REQUIRED)
    public void delete(@NotNull @Min(1) @Max(1000) Long id){
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

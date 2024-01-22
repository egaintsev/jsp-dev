package com.egor.jsp.project.facades;

import com.egor.jsp.project.models.Pharmacy;
import com.egor.jsp.project.models.TotalAmount;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class TotalAmountFacade implements Facade<TotalAmount>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(TotalAmount object) {
        entityManager.persist(object);
    }

    @Override
    public void update(TotalAmount object) {
        entityManager.merge(object);
    }

    @Override
    public void remove(String id) {
        TotalAmount totalAmount = findById(id);
        if (totalAmount != null) {
            entityManager.remove(totalAmount);
        }
    }

    @Override
    public TotalAmount findById(String id) {
        return entityManager.find(TotalAmount.class, Integer.parseInt(id));
    }

    @Override
    public List<TotalAmount> findAllRecords() {
        TypedQuery<TotalAmount> query = entityManager.createNamedQuery("Pharmacy.findAll", TotalAmount.class);
        return query.getResultList();
    }

}

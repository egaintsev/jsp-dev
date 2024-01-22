package com.egor.jsp.project.facades;

import com.egor.jsp.project.models.Pharmacy;
import com.egor.jsp.project.models.Pills;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PharmacyFacade implements Facade<Pharmacy>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Pharmacy object) {
        entityManager.persist(object);
    }

    @Override
    public void update(Pharmacy object) {
        entityManager.merge(object);
    }

    @Override
    public void remove(String id) {
        Pharmacy pharmacy = findById(id);
        if (pharmacy != null) {
            entityManager.remove(pharmacy);
        }
    }

    @Override
    public Pharmacy findById(String id) {
        return entityManager.find(Pharmacy.class, Integer.parseInt(id));
    }

    @Override
    public List<Pharmacy> findAllRecords() {
        TypedQuery<Pharmacy> query = entityManager.createNamedQuery("Pharmacy.findAll", Pharmacy.class);
        return query.getResultList();
    }

}

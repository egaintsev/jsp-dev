package com.egor.jsp.project.facades;

import com.egor.jsp.project.models.Pills;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class PillsFacade //implements Facade<Pills>
{

    @PersistenceContext
    private EntityManager entityManager;

    //@Override
    public void create(Pills object) {
        entityManager.persist(object);
    }

    //@Override
    public void update(Pills object) {
        entityManager.merge(object);
    }

    //@Override
    public void remove(String id) {
        Pills pill = findById(id);
        if (pill != null) {
            entityManager.remove(pill);
        }
    }

    //@Override
    public Pills findById(String id) {
        return entityManager.find(Pills.class, Integer.parseInt(id));
    }

    //@Override
    public List<Pills> findAllRecords() {
        TypedQuery<Pills> query = entityManager.createNamedQuery("Pills.findAll", Pills.class);
        return query.getResultList();
    }
}

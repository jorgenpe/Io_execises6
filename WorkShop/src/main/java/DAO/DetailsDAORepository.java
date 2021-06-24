package DAO;


import Models.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class DetailsDAORepository implements DetailsDAO{

    private final EntityManager entityManager;

    @Autowired
    public DetailsDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Details findById(int id) {
        return entityManager.find(Details.class, id);
    }

    @Override
    public Collection<Details> findAll() {
        return entityManager.createQuery("SELECT s FROM Details s", Details.class ).getResultList();
    }

    @Override
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    public void delete(int id) {

        if(entityManager.contains(findById(id))){
            entityManager.remove(findById(id));
        }

    }
}

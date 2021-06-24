package DAO;

import Models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class AppUserDAORepository implements AppUserDAO{


    private final EntityManager entityManager;

    @Autowired
    public AppUserDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public AppUser findById(int id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("SELECT s FROM AppUser s", AppUser.class ).getResultList();
    }

    @Override
    @Transactional
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    @Transactional
    public void delete(int id) {

        if(entityManager.contains(findById(id))){
            entityManager.remove(findById(id));
        }

    }
}

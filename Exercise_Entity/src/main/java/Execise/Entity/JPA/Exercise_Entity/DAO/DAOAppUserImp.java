package Execise.Entity.JPA.Exercise_Entity.DAO;

import Execise.Entity.JPA.Exercise_Entity.Models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
public class DAOAppUserImp implements DAOAppUser {

    private final EntityManager entityManager;

    @Autowired
    public DAOAppUserImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<AppUser> findById(int id) {
        return Optional.ofNullable(entityManager.find(AppUser.class, id));
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {


        return entityManager.merge(appUser);
    }

    @Override
    @Transactional
    public AppUser save(AppUser appUser) {
         entityManager.persist(appUser);
         return appUser;
    }

    @Override
    @Transactional
    public boolean Delete(AppUser appUser) {
        if(entityManager.contains(appUser)){
            entityManager.remove(appUser);
            return true;
        }
        return false;
    }
}

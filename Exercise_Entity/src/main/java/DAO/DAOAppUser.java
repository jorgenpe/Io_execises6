package DAO;

import Models.AppUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DAOAppUser {

    Optional<AppUser> findById(int id);
    AppUser update(AppUser appUser);
    AppUser save(AppUser appUser);
    boolean Delete(AppUser appUser);
}

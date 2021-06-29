package work_shop.WorkShop.DAO;

import work_shop.WorkShop.Models.AppUser;

import java.util.Collection;


public interface AppUserDAO {

    AppUser findById(int id);
    Collection<AppUser> findAll();
    AppUser create(AppUser appUser);
    AppUser update(AppUser appUser);
    void delete(int id);
}

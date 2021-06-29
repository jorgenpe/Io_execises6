package work_shop.WorkShop.DAO;

import work_shop.WorkShop.Models.AppUser;
import work_shop.WorkShop.Models.Author;

import java.util.Collection;

public interface AuthorDAO {

    Author findById(int id);
    Collection<Author> findAll();
    Author create(Author author);
    Author update(Author author);
    void delete(int id);
}

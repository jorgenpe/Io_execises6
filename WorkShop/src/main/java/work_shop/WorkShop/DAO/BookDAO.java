package work_shop.WorkShop.DAO;



import java.awt.print.Book;
import java.util.Collection;

public interface BookDAO {

    Book findById(int id);
    Collection<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void Delete(int id);
}

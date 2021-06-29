package work_shop.WorkShop.DAO;

import work_shop.WorkShop.Models.Book;
import work_shop.WorkShop.Models.BookLoan;

import java.util.Collection;

public interface BookLoanDAO {
    BookLoan findById(int id);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(int id);
}

package DAO;

import Models.Book;

import java.util.Collection;

public interface BookDAO {

    Book findById(int id);
    Collection<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void Delete(int id);
}

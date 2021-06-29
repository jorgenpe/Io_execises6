package work_shop.WorkShop.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.awt.print.Book;
import java.util.Collection;
@Repository
public class BookDAORepository implements BookDAO {

    private final EntityManager entityManager;

    @Autowired
    public BookDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Book> findAll() {
        return entityManager.createQuery("SELECT s FROM Book s", Book.class ).getResultList();
    }

    @Override
    @Transactional
    public Book create(Book book) {

        entityManager.persist(book);
        return book;
    }

    @Override
    @Transactional
    public Book update(Book book) {
        entityManager.merge(book);
        return book;
    }

    @Override
    @Transactional
    public void Delete(int id) {

        if(entityManager.contains(findById(id))){
            entityManager.remove(findById(id));
        }

    }
}

package work_shop.WorkShop.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import work_shop.WorkShop.Models.Author;

import javax.persistence.EntityManager;

import java.util.Collection;

public class AuthorDAORepository implements AuthorDAO {

    private final EntityManager entityManager;

    @Autowired
    public AuthorDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Author> findAll() {
        return entityManager.createQuery("SELECT s FROM Author s", Author.class ).getResultList();
    }

    @Override
    @Transactional
    public Author create(Author author) {

        entityManager.persist(author);
        return author;
    }

    @Override
    @Transactional
    public Author update(Author author) {
        entityManager.merge(author);
        return author;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    @Transactional
    public void delete(int id) {

        if(entityManager.contains(findById(id))){
            entityManager.remove(findById(id));
        }

    }
}

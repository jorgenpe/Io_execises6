package DAO;

import Models.Details;

import java.util.Collection;

public interface DetailsDAO {

    Details findById(int id);
    Collection<Details> findAll();
    Details create(Details details);
    Details update(Details details);
    void delete(int id);
}

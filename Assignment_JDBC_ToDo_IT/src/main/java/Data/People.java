package Data;

import Model.Person;

import java.util.Collection;

public interface People {

    Person create(Person person);
    Collection<Person> findAll();
    Person findById(int id);
    Collection<Person> FindByName(String name);
    Person update(Person person);
    boolean deleteById(int id);
}

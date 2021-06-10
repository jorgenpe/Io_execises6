package Data;

import Model.Person;

import java.util.Collection;

public interface People {

    Person create(Person person) throws IllegalAccessException;
    Collection<Person> findAll();
    Person findById(int id);
    Collection<Person> findByName(String name);
    Person update(Person person);
    boolean deleteById(int id);
}

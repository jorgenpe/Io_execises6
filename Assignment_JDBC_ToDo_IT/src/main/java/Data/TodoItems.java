package Data;

import Model.Person;
import Model.Todo;

import java.util.Collection;

public interface TodoItems {

    Todo create(Todo todo);
    Collection<Todo> findAll();
    Todo findById(int id);
    Collection<Todo> findByDoneStatus(Boolean bool);
    Collection<Todo> findByAssignee(int id);
    Collection<Todo> findByAssignee(Person person);
    Collection<Todo> findByUnassignedTodoItems();
    Todo update(Todo todo);
    boolean deleteById(int id);
}

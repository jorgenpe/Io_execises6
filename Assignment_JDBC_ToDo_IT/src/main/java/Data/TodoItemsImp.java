package Data;

import Model.Person;
import Model.Todo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class TodoItemsImp extends AbstractDAOCloseHelper implements TodoItems{

    @Override
    public Todo create(Todo todo) {

        if(todo == null) throw new IllegalArgumentException("Todo todo was null");
        if(todo.getTodoId() != 0) throw new IllegalArgumentException("todoId is already set and todo can't be created");
        if(todo.getAssignee() != null){
            if(todo.getAssignee().getId() == 0) throw new IllegalArgumentException("Todo  have a illegal person");
        }else{
            throw new IllegalArgumentException("Person was null");
        }

        Todo createdTodo = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConnectionBuilder.getConnection();
            statement = connection.prepareStatement("INSERT INTO todo_item (title, description, deadline,done, assignee_id) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, todo.getTitle());
            statement.setString(2, todo.getDescription());
            statement.setDate(3,Date.valueOf(todo.getDeadline()));
            statement.setBoolean(4, todo.isDone());
            statement.setInt(5, todo.getAssignee().getId());
            statement.execute();
            resultSet = statement.getGeneratedKeys();
            while(resultSet.next()){
                createdTodo = new Todo(
                        resultSet.getInt(1),
                        todo.getTitle(),
                        todo.getDescription(),
                        todo.getDeadline(),
                        todo.isDone(),
                        todo.getAssignee()
                );
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            closeAll(resultSet, statement, connection);
        }


        return createdTodo;
    }

    @Override
    public Collection<Todo> findAll() {
        People people = new PeopleImp();
        Collection<Todo> todoList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConnectionBuilder.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM todo_item");

                    while(resultSet.next()){
                        todoList.add(new Todo(
                                resultSet.getInt("todo_id"),
                                resultSet.getString("title"),
                                resultSet.getString("description"),
                                resultSet.getDate("deadline").toLocalDate(),
                                resultSet.getBoolean("done"),
                                people.findById(resultSet.getInt("assignee_id"))
                        ));
                    }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            closeAll(resultSet,statement,connection);

        }



        return todoList;
    }

    @Override
    public Todo findById(int id) {

        People people = new PeopleImp();
        Todo todo = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConnectionBuilder.getConnection();
            statement = connection.prepareStatement("SELECT * FROM todo_item WHERE todo_id = ? ");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                todo =new Todo(
                        resultSet.getInt("todo_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("deadline").toLocalDate(),
                        resultSet.getBoolean("done"),
                        people.findById(resultSet.getInt("assignee_id"))
                );
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            closeAll(resultSet,statement,connection);

        }


        return todo;
    }

    @Override
    public Collection<Todo> findByDoneStatus(Boolean bool) {

        People people = new PeopleImp();
        Collection<Todo> todoList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConnectionBuilder.getConnection();
            statement = connection.prepareStatement("SELECT * FROM todo_item WHERE done = ?");
            statement.setBoolean(1, bool );
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                todoList.add(new Todo(
                        resultSet.getInt("todo_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("deadline").toLocalDate(),
                        resultSet.getBoolean("done"),
                        people.findById(resultSet.getInt("assignee_id"))
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            closeAll(resultSet,statement,connection);

        }



        return todoList;
    }


    @Override
    public Collection<Todo> findByAssignee(int id) {

        People people = new PeopleImp();
        Collection<Todo> todoList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConnectionBuilder.getConnection();
            statement = connection.prepareStatement("SELECT * FROM todo_item WHERE assignee_id = ?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                todoList.add(new Todo(
                        resultSet.getInt("todo_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("deadline").toLocalDate(),
                        resultSet.getBoolean("done"),
                        people.findById(resultSet.getInt("assignee_id"))
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            closeAll(resultSet,statement,connection);

        }



        return todoList;
    }

    @Override
    public Collection<Todo> findByAssignee(Person person) {

        People people = new PeopleImp();
        Collection<Todo> todoList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConnectionBuilder.getConnection();
            statement = connection.prepareStatement("SELECT * FROM todo_item WHERE assignee_id = ?");
            statement.setInt(1,person.getId());
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                todoList.add(new Todo(
                        resultSet.getInt("todo_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("deadline").toLocalDate(),
                        resultSet.getBoolean("done"),
                        people.findById(resultSet.getInt("assignee_id"))
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            closeAll(resultSet,statement,connection);

        }



        return todoList;
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        return null;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}

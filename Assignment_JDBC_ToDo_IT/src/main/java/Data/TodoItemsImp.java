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
            if(todo.getAssignee().getId() == 0)throw new IllegalArgumentException("Person was null");
        }


        Todo createdTodo = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int assign_id ;
        if(todo.getAssignee() == null){
            assign_id = 0;
        }else
        {
            assign_id = todo.getAssignee().getId();
        }

        try{
            connection = ConnectionBuilder.getConnection();
            statement = connection.prepareStatement("INSERT INTO todo_item (title, description, deadline,done, assignee_id) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, todo.getTitle());
            statement.setString(2, todo.getDescription());
            statement.setDate(3,Date.valueOf(todo.getDeadline()));
            statement.setBoolean(4, todo.isDone());
            statement.setInt(5, assign_id);
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

    // A little tricky to solve. Was forced to do a thing with toString in Todo to handle the fallout.
    @Override
    public Collection<Todo> findByUnassignedTodoItems() {

        Collection<Todo> todoList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConnectionBuilder.getConnection();
            statement = connection.prepareStatement("SELECT * FROM todo_item WHERE assignee_id IS NULL ");
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                todoList.add(new Todo(
                        resultSet.getInt("todo_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("deadline").toLocalDate(),
                        resultSet.getBoolean("done")


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
    public Todo update(Todo todo) {

        People people = new PeopleImp();
        Todo todoTemp = null;
        Connection connection = null;
        PreparedStatement statement = null;


        try{

            connection = ConnectionBuilder.getConnection();
            statement = connection.prepareStatement("UPDATE todo_item SET title = ?, description = ?,deadline = ?, done = ?, assignee_id = ? WHERE todo_id = ?");
            statement.setString(1,todo.getTitle());
            statement.setString(2,todo.getDescription());
            statement.setDate(3,Date.valueOf(todo.getDeadline()));
            statement.setBoolean(4,todo.isDone());
            statement.setInt(5,todo.getAssignee().getId());
            statement.setInt(6,todo.getTodoId());
            statement.execute();


        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            closeAll(statement,connection);

        }


        return todo;

    }

    @Override
    public boolean deleteById(int id) {


        Connection connection = null;
        PreparedStatement statement = null;
        int rowsDeleted = 0;
        try{
            connection = ConnectionBuilder.getConnection();
            statement = connection.prepareStatement("DELETE FROM todo_item WHERE todo_id = ?");
            statement.setInt(1, id);
            rowsDeleted = statement.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }finally {
            closeAll(statement, connection);
        }

        return rowsDeleted > 0;
    }
}

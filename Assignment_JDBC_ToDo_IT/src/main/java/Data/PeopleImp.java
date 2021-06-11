package Data;

import Model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class PeopleImp extends AbstractDAOCloseHelper implements People {

    @Override
    public Person create(Person person)  {


        if(person == null) throw new IllegalArgumentException("Person can't be null");
        if(person.getId() != 0) throw new IllegalArgumentException("Person already exist i database.");

        Person createdResult = null;
        Connection connection = null;
        PreparedStatement  statement= null;
        ResultSet keySet = null;

        try{
            connection = ConnectionBuilder.getConnection();
            statement = connection.prepareStatement("INSERT INTO person (first_name,last_name) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.execute();

            keySet = statement.getGeneratedKeys();

            while(keySet.next()){

                createdResult = new Person(
                        keySet.getInt(1),
                        person.getFirstName(),
                        person.getLastName()
                );
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally{
            closeAll(keySet, statement, connection);
        }

        return createdResult;
    }

    @Override
    public Collection<Person> findAll() {

        Collection<Person> personList = new ArrayList<>();

        try(
                Connection connection = ConnectionBuilder.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM person")
                )
        {
            while(resultSet.next()){
                personList.add(new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                        ));
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return personList;
    }

    @Override
    public Person findById(int id) {

            Person person = new Person();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

        try{
                connection = ConnectionBuilder.getConnection();
                preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE person_id = ?");
                preparedStatement.setInt(1,id);
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    person = new Person(
                            resultSet.getInt("person_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name")
                    );
                }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            closeAll(resultSet,preparedStatement,connection);
        }
        return person;
    }

    @Override
    public Collection<Person> findByName(String name) {

        Collection<Person> persons = new ArrayList<>();
        String tempFirstName;
        String tempLastName;

        int index = name.indexOf(" ");
        tempFirstName = name.substring(0, index).trim();
        tempLastName = name.substring(index +1 ,name.length()).trim();


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = ConnectionBuilder.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE first_name = ? and last_name = ?");
            preparedStatement.setString(1,tempFirstName);
            preparedStatement.setString(2,tempLastName);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                persons.add(new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"))
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            closeAll(resultSet,preparedStatement,connection);
        }




        return persons;
    }

    @Override
    public Person update(Person person) {

            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try{
                connection = ConnectionBuilder.getConnection();
                preparedStatement = connection.prepareStatement("UPDATE  person SET first_name = ?, last_name = ? WHERE person_id = ?");
                preparedStatement.setString(1,person.getFirstName());
                preparedStatement.setString(2,person.getLastName());
                preparedStatement.setInt(3, person.getId());
                preparedStatement.execute();
            }catch (SQLException ex){
                ex.printStackTrace();
            }finally{
                closeAll(preparedStatement, connection);
            }


        return person;
    }

    @Override
    public boolean deleteById(int id) {

        //Was forced to divide the query to two part to solve delete. The foreign key dilemma.
        Connection connection = null;
        PreparedStatement statement = null;
        int rowsDeleted = 0;
        try{
            connection = ConnectionBuilder.getConnection();
            statement = connection.prepareStatement("UPDATE todo_item SET assignee_id = NULL WHERE assignee_id = ?  " );
            statement.setInt(1, id);
            rowsDeleted = statement.executeUpdate();
            statement = connection.prepareStatement("DELETE FROM person WHERE person_id = ?");
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

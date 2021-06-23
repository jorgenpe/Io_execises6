package org.example;


import Data.People;
import Data.PeopleImp;
import Data.TodoItems;
import Data.TodoItemsImp;
import Model.Person;
import Model.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class App
{
    public static void main( String[] args ) throws IllegalAccessException {

        /*Collection<Person> testPerson = new ArrayList<>();


        boolean testBool= false;



        //testPerson.setLastName("Erikson");

        //testPerson = testPeople.update(testPerson);
        testBool = testPeople.deleteById(1);

        System.out.println(testBool);*/
        //Person testPerson = new Person();
        //People testPeople = new PeopleImp();
        //testPeople.deleteById(2);
        TodoItems todoItems = new TodoItemsImp();
        //todoItems.deleteById(1);
        //testPerson = testPeople.create(new Person("Anders", "Svensson"));
        //System.out.println(testPerson.toString());
       //testPerson =  testPeople.findById(2);

       //Todo todo = new Todo("Hej", "heja", LocalDate.of(2021,2,2), true, testPerson);

       //todo = todoItems.create(todo);
        Collection<Todo> todoList = new ArrayList<>();
        //Todo todo = new Todo();
       // todoList = todoItems.findAll();

        todoList = todoItems.findByUnassignedTodoItems();

       // System.out.println(todo.toString());
        //todoList = todoItems.findAll();
       for(Todo m: todoList){
            System.out.println(m.toString());
        }
        /*todo = todoItems.findById(2);

        todo.setDeadline(LocalDate.of(2021,4,28));
        todo.setDescription("Hej och hå");

        todo = todoItems.update(todo);*/


    }
}

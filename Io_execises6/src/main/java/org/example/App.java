package org.example;


import Model.Car;
import Model.Owner;
import io.ObjectSerializerCar;

import java.io.File;
import java.time.LocalDate;
import java.util.*;


public class App
{
    public static void main( String[] args )
    {
        Collection<Car> carList = new HashSet<>();
        Collection<Owner> ownerList = new HashSet<>();
        Collection<Car> carListTest = new HashSet<>();
        Collection<Owner> ownerListTest = new HashSet<>();


        ownerList = newOwners(ownerList);
        carList = newCarsCollection(carList,ownerList);

        ObjectSerializerCar cars = new ObjectSerializerCar();

        cars.serializeOwnerToJson(ownerList,new File("src/main/java/Json/owners.json"));
        cars.serializeCarToJson(carList,new File("src/main/java/Json/cars.json"));

        ownerListTest = cars.deserializeOwner(new File("src/main/java/Json/owners.json"));
        carListTest = cars.deserializeCar(new File("src/main/java/Json/cars.json"));

        System.out.println(carListTest.size());
        for(Car m : carListTest){
            System.out.println(m.toString());
        }

    }

    public static Collection<Owner> newOwners(Collection<Owner> ownerList){

        Owner owner = new Owner();


        owner.setFirstName("Anna");
        owner.setLastName("Olson");
        owner.setBirthDay(LocalDate.of(2000,4,15));
        owner.setOwnerId(1);
        ownerList.add(owner);

        owner = new Owner();
        owner.setFirstName("Ann");
        owner.setLastName("Nilson");
        owner.setBirthDay(LocalDate.of(1996,12,24));
        owner.setOwnerId(2);
        ownerList.add(owner);

        owner = new Owner();
        owner.setFirstName("Adam");
        owner.setLastName("Erikson");
        owner.setBirthDay(LocalDate.of(2003,5,28));
        owner.setOwnerId(3);
        ownerList.add(owner);

        return ownerList;
    }


    public static Collection<Car> newCarsCollection(Collection<Car> carList, Collection<Owner> ownerList){

        List<Owner> temp = new ArrayList<>(ownerList);
        Car car = new Car();

        car.setCarId(1);
        car.setBrand("Ford");
        car.setCarReg("FGH 505");
        car.setModel("Focus");
        car.setRegDate(LocalDate.of(2020,1,2));
        car.setOwner(temp.get(0));
        carList.add(car);

        car = new Car();
        car.setCarId(2);
        car.setBrand("Volvo");
        car.setCarReg("DRT 591");
        car.setModel("v40");
        car.setRegDate(LocalDate.of(2019,5,2));
        car.setOwner(temp.get(0));
        carList.add(car);

        car = new Car();
        car.setCarId(3);
        car.setBrand("Audi");
        car.setCarReg("FLK 452");
        car.setModel("A3");
        car.setRegDate(LocalDate.of(2018,8,23));
        car.setOwner(temp.get(1));
        carList.add(car);

        car = new Car();
        car.setCarId(4);
        car.setBrand("Volvo");
        car.setCarReg("FGH 515");
        car.setModel("v60");
        car.setRegDate(LocalDate.of(2020,12,12));
        car.setOwner(temp.get(2));
        carList.add(car);
        return carList;
    }



}

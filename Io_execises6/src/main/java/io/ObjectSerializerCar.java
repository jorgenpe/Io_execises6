package io;

import Model.Car;
import Model.Owner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class ObjectSerializerCar {

    private ObjectMapper objectMapper;

    public ObjectSerializerCar(){

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public void serializeCarToJson(Collection<Car> carList, File file){

        try{
            if(!file.exists()){
                file.createNewFile();
            }
            objectMapper.writeValue(file, carList);

        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public void serializeOwnerToJson(Collection<Owner> ownerList, File file){

        try{
            if(!file.exists()){
                file.createNewFile();
            }
            objectMapper.writeValue(file, ownerList);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public Collection<Car> deserializeCar(File file){

        Collection<Car> cars = new HashSet<>();

        try{

            cars = objectMapper.readValue(file, new TypeReference<Collection<Car>>() {});

        }catch(Exception e){
            e.printStackTrace();
        }

        return cars;
    }

    public Collection<Owner> deserializeOwner(File file){

        Collection<Owner> owners = new HashSet<>();

        try{

            owners = objectMapper.readValue(file, new TypeReference<Collection<Owner>>() {});

        }catch(Exception e){
            e.printStackTrace();
        }

        return owners;
    }

}

package com.example.excercise.service;

import com.example.excercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

   /* Tener la restApi para usar metodos
   public ArrayList<Persons> getPersons(){
        PersonRepository

    }*/
}

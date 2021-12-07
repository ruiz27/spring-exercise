package com.example.excercise.service;

import com.example.excercise.dto.Person;
import com.example.excercise.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Service
@RestController
public class PersonService implements IPersonService{

    private final PersonRepository personRepository;

    //inyeccion de dependencias por contructor, no por autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPerson() {
        return null;
    }
}

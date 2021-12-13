package com.example.excercise.service;
import com.example.excercise.dto.PersonDto;
import com.example.excercise.entities.Person;
import com.example.excercise.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class PersonService implements IPersonService {

    private final PersonRepository personRepository;
    private Person person;


    //inyeccion de dependencias por contructor, no por autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonDto> getAllPerson() {

        List<PersonDto> personDtoList = new ArrayList();
        List<Person> personEntityList = personRepository.findAll();
        for (Person person : personEntityList) {
            PersonDto personDto = new PersonDto();
            personDto.setId(person.getId());
            personDto.setUsername(person.getUsername());
            personDto.setFirstName(person.getFirstname());
            personDto.setLastName(person.getLastname());
            personDto.setEmail(person.getEmail());
            personDto.setPassword(person.getPassword());
            personDto.setPhone(person.getPhone());
            personDto.setUserStatus(person.getUserstatus());

            personDtoList.add(personDto);
        }
        return personDtoList;
    }

    @Override
    public PersonDto postOnePerson(PersonDto body) {
        Person personAdded = new Person();
        personAdded.setId(body.getId());
        personAdded.setUsername(body.getUsername());
        personAdded.setFirstname(body.getFirstName());
        personAdded.setLastname(body.getLastName());
        personAdded.setEmail(body.getEmail());
        personAdded.setPassword(body.getPassword());
        personAdded.setPhone(body.getPhone());
        personAdded.setUserstatus(body.getUserStatus());
        personRepository.save(personAdded);

        PersonDto personDtoAdded = new PersonDto();
        personDtoAdded.setId(personAdded.getId());
        personDtoAdded.setUsername(personAdded.getUsername());
        personDtoAdded.setFirstName(personAdded.getFirstname());
        personDtoAdded.setLastName(personAdded.getLastname());
        personDtoAdded.setEmail(personAdded.getEmail());
        personDtoAdded.setPassword(personAdded.getPassword());
        personDtoAdded.setPhone(personAdded.getPhone());
        personDtoAdded.setUserStatus(personAdded.getUserstatus());

        return personDtoAdded;
    }

    @Override
    public PersonDto deleteOnePerson(Integer id) {
        PersonDto personDtoDeleted = new PersonDto();
        List<Person> personEntityList = personRepository.findAll();
        for (Person person : personEntityList) {
            if (person.getId().equals(id)) {

                personDtoDeleted.setId(person.getId());
                personDtoDeleted.setUsername(person.getUsername());
                personDtoDeleted.setFirstName(person.getFirstname());
                personDtoDeleted.setLastName(person.getLastname());
                personDtoDeleted.setEmail(person.getEmail());
                personDtoDeleted.setPassword(person.getPassword());
                personDtoDeleted.setPhone(person.getPhone());
                personDtoDeleted.setUserStatus(person.getUserstatus());
                personRepository.delete(person);
            }
        }
        return personDtoDeleted;
    }

    @Override
    public PersonDto getPersonById(Integer id) {
        PersonDto personRequested = new PersonDto();
       List<Person> personEntityList = personRepository.findAll();
       for (Person person: personEntityList){
           if(person.getId().equals(id)){

               personRequested.setId(person.getId());
               personRequested.setUsername(person.getUsername());
               personRequested.setFirstName(person.getFirstname());
               personRequested.setLastName(person.getLastname());
               personRequested.setEmail(person.getEmail());
               personRequested.setPassword(person.getPassword());
               personRequested.setPhone(person.getPhone());
               personRequested.setUserStatus(person.getUserstatus());
           }
       }
        return personRequested;
    }
}
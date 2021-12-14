package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.entity.Person;
import com.example.excercise.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonService implements IPersonService{

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List <PersonDto> getAllPeople() {
        List<PersonDto> personDtoList = new ArrayList<>();
        List<Person> personList = personRepository.findAll();

        PersonDto personDto;
        for(Person person : personList){
            personDto = new PersonDto();
            personDto.setId(person.getId());
            personDto.setUserName(person.getUserName());
            personDto.setFirstName(person.getFirstName());
            personDto.setLastName(person.getLastName());
            personDto.setPassword(person.getPassword());
            personDto.setEmail(person.getEmail());
            personDto.setPhone(person.getPhone());
            personDto.setUserStatus(person.getUserStatus());

            personDtoList.add(personDto);

        }
        return personDtoList;
    }

    public PersonDto getPersonById(Integer id){
        PersonDto personRequested = new PersonDto();
        Optional <Person> personEntityList = personRepository.findById(id);

            if(personEntityList.isPresent()){
                Person person = personEntityList.get();
                personRequested.setId(person.getId());
                personRequested.setUserName(person.getUserName());
                personRequested.setFirstName(person.getFirstName());
                personRequested.setLastName(person.getLastName());
                personRequested.setPassword(person.getPassword());
                personRequested.setEmail(person.getEmail());
                personRequested.setPhone(person.getPhone());
                personRequested.setUserStatus(person.getUserStatus());
            }
        return personRequested;
    }

    @Override
    public void addOnePerson(PersonDto personDto) {
        Person person = new Person();
        person.setId(personDto.getId());
        person.setUserName(personDto.getUserName());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setPassword(personDto.getPassword());
        person.setEmail(personDto.getEmail());
        person.setPhone(personDto.getPhone());
        person.setUserStatus(personDto.getUserStatus());

        personRepository.save(person);
        log.info("Persona creada");
    }

    @Override
    public PersonDto deleteOnePerson(Integer id){
        PersonDto personRequested = new PersonDto();
        Optional <Person> personEntityList = personRepository.findById(id);

            if(personEntityList.isPresent()){
                Person person = personEntityList.get();
                personRequested.setId(person.getId());
                personRequested.setUserName(person.getUserName());
                personRequested.setFirstName(person.getFirstName());
                personRequested.setLastName(person.getLastName());
                personRequested.setPassword(person.getPassword());
                personRequested.setEmail(person.getEmail());
                personRequested.setPhone(person.getPhone());
                personRequested.setUserStatus(person.getUserStatus());

                personRepository.delete(personEntityList.get());
                log.info("Persona borrada");
            }
        return personRequested;
    }
}

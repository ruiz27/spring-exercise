package com.example.excercise.service;

import com.example.excercise.dto.ResponseDto;
import com.example.excercise.dto.PersonDto;
import com.example.excercise.entities.Person;
import com.example.excercise.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PersonService implements IPersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonDto> getPeopleList() {
        PersonDto personDto;
        List<PersonDto> personDtoList = new ArrayList();
        List<Person> personEntityList = personRepository.findAll();
        for (Person person : personEntityList) {
            personDto = new PersonDto();
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
    public ResponseDto createPerson(PersonDto body) {
        ResponseDto response = new ResponseDto();
        Person personAdded = new Person();
        PersonDto personDtoAdded= new PersonDto();
        Optional<Person> person = personRepository.findById(body.getId());
        if(!person.isPresent()) {
            log.debug("Se realizará el registro");
            personAdded.setId(body.getId());
            personAdded.setUsername(body.getUsername());
            personAdded.setFirstname(body.getFirstName());
            personAdded.setLastname(body.getLastName());
            personAdded.setEmail(body.getEmail());
            personAdded.setPassword(body.getPassword());
            personAdded.setPhone(body.getPhone());
            personAdded.setUserstatus(body.getUserStatus());
            personRepository.save(personAdded);

            personDtoAdded.setId(personAdded.getId());
            personDtoAdded.setUsername(personAdded.getUsername());
            personDtoAdded.setFirstName(personAdded.getFirstname());
            personDtoAdded.setLastName(personAdded.getLastname());
            personDtoAdded.setEmail(personAdded.getEmail());
            personDtoAdded.setPassword(personAdded.getPassword());
            personDtoAdded.setPhone(personAdded.getPhone());
            personDtoAdded.setUserStatus(personAdded.getUserstatus());

            log.debug("Registro realizado con éxito");
            response.setCode(4);
            response.setMessage("La persona se ha añadido a la base de datos");
            return response;
        }else{
            log.debug("No se ha añadido,la persona ya existía en la base de datos");
            log.info("No se ha añadido,la persona ya existía en la base de datos");

            response.setCode(1);
            response.setMessage("ERROR, la persona ya existe en la base de datos");
            return response;
        }

    }

    @Override
    public ResponseDto deletePersonById(Integer id) {

        log.debug("ini endpoint deleteById");
        ResponseDto response = new ResponseDto();
        Optional<Person> personToDelete = personRepository.findById(id);
        if(personToDelete.isPresent()) {
            personRepository.delete(personToDelete.get());
            log.debug("Se ha borrado la persona en persistencia de datos correctamente.");
            response.setCode(4);
            response.setMessage("La persona se ha borrado correctamente de la base de datos");
        }else{
            log.debug("La persona no existe en la base de datos");
            log.info("La persona no existe en la base de datos");
            response.setCode(1);
            response.setMessage("ERROR, la persona NO existe en la base de datos");
        }
        return response;
    }


    @Override
    public PersonDto getPersonById(Integer id) {
        log.debug("ini endpoint getPersonById");
       PersonDto personRequestedDto = new PersonDto();
       Optional<Person> personRequested = personRepository.findById(id);
       if(personRequested.isPresent()) {
           Person personFound = personRequested.get();
           personRequestedDto.setId(personFound.getId());
           personRequestedDto.setUsername(personFound.getUsername());
           personRequestedDto.setFirstName(personFound.getFirstname());
           personRequestedDto.setLastName(personFound.getLastname());
           personRequestedDto.setEmail(personFound.getEmail());
           personRequestedDto.setPassword(personFound.getPassword());
           personRequestedDto.setPhone(personFound.getPhone());
           personRequestedDto.setUserStatus(personFound.getUserstatus());
           log.info("Se ha encontrado la persona");
       }
        log.debug("Se ha encontrado la persona en la persistencia de datos correctamente.");
        return personRequestedDto;
    }
}
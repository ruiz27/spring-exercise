package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;
import com.example.excercise.entity.Person;
import com.example.excercise.mapper.PersonMapper;
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
            personDto = PersonMapper.INSTANCIA.personToPersonDto(person);
            personDtoList.add(personDto);
        }
        return personDtoList;
    }

    @Override
    public PersonDto getPersonById(Integer id){
        PersonDto personDto;
        Optional <Person> personEntityList = personRepository.findById(id);

            if(personEntityList.isPresent()){
                Person person = personEntityList.get();
                personDto = PersonMapper.INSTANCIA.personToPersonDto(person);
            }
            else{
                personDto = null;
            }
        return personDto;
    }

   @Override
    public ResponseDto addOnePerson(PersonDto personDto) {
       ResponseDto responseDto = null;
       Optional <Person> personEntityList = personRepository.findById(personDto.getId());
           if (personEntityList.isPresent()){
               responseDto = new ResponseDto("ID existente. Por favor, introduzca un ID libre.","KO");
           }
           else{
               Person person = PersonMapper.INSTANCIA.personDtoToPerson(personDto);
               personRepository.save(person);
               responseDto = new ResponseDto("Persona creada correctamente", "OK");
           }
           return responseDto;
    }

    @Override
    public ResponseDto deleteOnePerson(Integer id){
        PersonDto personRequested = new PersonDto();
        ResponseDto responseDto = null;
        Optional <Person> personEntityList = personRepository.findById(id);

            if(personEntityList.isPresent()){
                Person person = PersonMapper.INSTANCIA.personDtoToPerson(personRequested);
                personRequested.setUserStatus(person.getUserStatus());

                personRepository.delete(personEntityList.get());
                responseDto =  new ResponseDto("Persona eliminada","OK");
            }
            else{
                responseDto = new ResponseDto("Persona no encontrada","WARN");
            }
        return responseDto;
    }
}

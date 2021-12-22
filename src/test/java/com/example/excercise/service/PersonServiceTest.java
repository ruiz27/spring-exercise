package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;
import com.example.excercise.entities.Person;
import com.example.excercise.mapper.PersonMapper;
import com.example.excercise.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PersonServiceTest {

    private PersonDto personDto;

    @InjectMocks
    PersonService personService;

    @Mock
    PersonRepository personRepository;

    @Mock
    PersonMapper personMapper;



    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        personDto = new PersonDto();
        personDto.setId(1);
        personDto.setUsername("test");
        personDto.setFirstName("test");
        personDto.setLastName("test");
        personDto.setEmail("test");
        personDto.setPassword("test");
        personDto.setPhone("32452623");
        personDto.setUserStatus(2);

    }
    @Test
    public void whenGetPeopleListThenReturnList(){
        //Given
        List<Person> list = new ArrayList<>();
        Person person1 = new Person(2,"pluis","pepe","luis","pluis@mail.com","12345","54565434",1);
        list.add(person1);
        //When
        Mockito.when(personRepository.findAll()).thenReturn(list);
        //Then
        assertEquals(1,personService.getPeopleList().size());

    }

    @Test
    public void whenCreatePersonThenResultOk(){
        //When
        Mockito.when(personRepository.findById(personDto.getId())).thenReturn(Optional.empty());
        ResponseDto responseDto = personService.createPerson(personDto);
        //Then
        assertEquals(4, responseDto.getCode());
    }

    @Test
    public void whenCreatePersonThatExistsThenResultError(){
        //Given
        Person person1 = new Person(1,"pluis","pepe","luis","pluis@mail.com","12345","54565434",1);
        //When
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.of(person1));
        ResponseDto response = personService.createPerson(personDto);
        //Then
        assertEquals(1, response.getCode());
    }

    @Test
    public void whenDeletePersonThatExistsThenResultOk(){
        //Given
        Person person1 = new Person(1,"pluis","pepe","luis","pluis@mail.com","12345","54565434",1);
        //When
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.of(person1));
        ResponseDto response = personService.deletePersonById(person1.getId());
        //Then
        assertEquals(4, response.getCode());
    }
    @Test
    public void whenDeletePersonThatNotExistsThenResultError(){
        //Given
        Person person1 = new Person(1,"pluis","pepe","luis","pluis@mail.com","12345","54565434",1);
        //When
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.empty());
        ResponseDto response = personService.deletePersonById(person1.getId());
        //Then
        assertEquals(1, response.getCode());
    }


    @Test
    public void whenGetPersonThatExistsThenReturnPersonDto(){
        //Given
        Person person1 = new Person(1,"pluis","pepe","luis","pluis@mail.com","12345","54565434",1);
        //When
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.of(person1));
        personService.getPersonById(person1.getId());
        //Then
        assertEquals("pluis",person1.getUsername());
    }

}

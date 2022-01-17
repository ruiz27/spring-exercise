package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;
import com.example.excercise.entity.Person;
import com.example.excercise.entity.PersonAttributes;
import com.example.excercise.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class PersonServiceTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    private PersonDto personDto;

    @Before
    public void init() {
        personDto = new PersonDto();
        personDto.setId(1);
        personDto.setPhone("651597587");
        personDto.setEmail("sonia.bencomo@vass.es");
        personDto.setPassword("soniabencomo");
        personDto.setUserStatus(1);
        personDto.setLastName("Bencomo Jorge");
        personDto.setFirstName("Sonia");
        personDto.setUserName("sonia.bencomo");
    }

    @Test
    public void whenAddOnePersonThenResultOk() {
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.empty());
        // when
        ResponseDto responseDto = personService.addOnePerson(personDto);
        // then
        assertEquals("OK",responseDto.getCode());
    }

    @Test
    public void whenAddOnePersonWhitSameIDThenResultKo(){
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.of(new Person()));
        // when
        ResponseDto responseDto = personService.addOnePerson(personDto);
        // then
        assertEquals("KO",responseDto.getCode());
    }

    @Test
    public void whenDeleteOnePersonThenResultOk(){
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.of(new Person()));
        //when
        ResponseDto responseDto = personService.deleteOnePerson(personDto.getId());
        //then
        assertEquals("OK",responseDto.getCode());
    }

    @Test
    public void whenDeleteOnePersonNotFoundThenResultKo(){
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.empty());
        // when
        ResponseDto responseDto = personService.deleteOnePerson(personDto.getId());
        // then
        assertEquals("WARN",responseDto.getCode());
    }

    @Test
    public void whenGetPeopleByNameThenResultOk() {
        Person person = new Person(1,"sonia.bencomo","Sonia","Bencomo Jorge","sonia.bencomo@vass.es","soniabencomo","651597587",1, new PersonAttributes());
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        Mockito.when(personRepository.findAll()).thenReturn(List.of(person));
        // when
        List<PersonDto> personDtoList = personService.getPeopleByName("Sonia");
        // then
        assertEquals(1,personList.size());
    }

    @Test
    public void whenGetPeopleByNameNotFoundThenResultOk(){
        Person person = new Person();
        List<Person> personList = new ArrayList<>();
        Mockito.when(personRepository.findAll()).thenReturn(List.of(person));
        // when
        List <PersonDto> personDtoList = personService.getPeopleByName("Sonia");
        // then
        assertEquals(0,personList.size());
    }

    @Test
    public void whenGetPersonByIdThenResultOk(){
        Person person = new Person(1,"sonia.bencomo","Sonia","Bencomo Jorge","sonia.bencomo@vass.es","soniabencomo","651597587",1, new PersonAttributes());
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.of(person));
        // when
        personDto = personService.getPersonById(personDto.getId());
        // then
        assertEquals(Integer.valueOf(1), person.getId());
    }

    @Test
    public void whenGetPersonByIdNotFoundThenResultKo(){
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.empty());
        // when
        personDto = personService.getPersonById(personDto.getId());
        // then
        Assert.assertNull(personDto);
    }

    @Test
    public void whenGetAllPeopleThenResultOk(){
        Person person = new Person(1,"sonia.bencomo","Sonia","Bencomo Jorge","sonia.bencomo@vass.es","soniabencomo","651597587",1, new PersonAttributes());
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        Mockito.when(personRepository.findAll()).thenReturn(List.of(person));
        // when
        List<PersonDto> personDtoList = personService.getAllPeople();
        // then
        assertEquals(1,personList.size());
    }

    @Test
    public void whenGetAllPeopleIsEmptyThenResultKo(){
        Person person = new Person();
        List<Person> personList = new ArrayList<>();
        Mockito.when(personRepository.findAll()).thenReturn(List.of(person));
        // when
        List <PersonDto> personDtoList = personService.getAllPeople();
        // then
        assertEquals(0,personList.size());
    }
}

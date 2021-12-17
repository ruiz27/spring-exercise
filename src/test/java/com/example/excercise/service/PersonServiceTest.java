package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;
import com.example.excercise.entity.Person;
import com.example.excercise.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    private PersonDto personDto;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

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
    public void whenGetPersonByIdThenResultOk(){
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.of(new Person()));
        // when
        personDto = personService.getPersonById(personDto.getId());
        // then

    }

    @Test
    public void whenGetPersonByIdNotFoundThenResultKo(){
        Mockito.when(personRepository.findById(1)).thenReturn(Optional.empty());
        // when
        personDto = personService.getPersonById(personDto.getId());
        // then

    }

    @Test
    public void whenGetAllPeopleThenResultOk(){
        Mockito.when(personRepository.findAll()).thenReturn(List.of(new Person()));
        // when
        List <PersonDto> personDtoList = personService.getAllPeople();
        // then

    }

    @Test
    public void whenGetAllPeopleIsEmptyThenResultKo(){
        Mockito.when(personRepository.findAll()).thenReturn(List.of(new Person()));
        // when
        List <PersonDto> personDtoList = null;
        // then

    }
}

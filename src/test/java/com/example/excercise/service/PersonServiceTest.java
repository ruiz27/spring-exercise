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
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PersonServiceTest {

    private Person person;
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
        personDto.setId(1);
        personDto.setUsername("test");
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
        Mockito.when(personRepository.findAll()).thenReturn(List.of(person));
        //When

        //Then

    }
    @Test
    public void whenGetEmptyPeopleListThenReturnError(){

        //When

        //Then

    }
    @Test
    public void whenCreatePersonThenResultOk(){
        Mockito.when(personRepository.findById(personDto.getId())).thenReturn(Optional.empty());
        //When
        ResponseDto responseDto = personService.createPerson(personDto);
        //Then
        assertEquals(4, responseDto.getCode());
    }

    @Test
    public void whenCreatePersonThatExistsThenResultError(){

        //When

        //Then

    }

    @Test
    public void whenDeletePersonThatExistsThenResultOk(){

        //When

        //Then

    }

    @Test
    public void whenDeletePersonThatNotExistsThenResultError(){

        //When

        //Then

    }
    @Test
    public void whenGetPersonThatExistsThenResultOk(){

        //When

        //Then

    }
    @Test
    public void whenGetPersonThatNotExistsThenResultError(){

        //When

        //Then

    }

}

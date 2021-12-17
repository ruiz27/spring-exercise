package com.example.excercise.controller;

import com.example.excercise.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PersonApiControllerTest {

    @InjectMocks
    PersonApiController controller;

    @Mock
    PersonService servide;

    @BeforeEach
    public void init() {

    }

    @Test
    public void whenGetPeopleListThenReturnList(){

        //When

        //Then

    }
    @Test
    public void whenGetEmptyPeopleListThenReturnError(){

        //When

        //Then

    }

    @Test
    public void whenCreatePersonThenReturnOk(){

        //when

        //Then

    }
    @Test
    public void whenCreatePersonThatExistThenReturnError(){

        //when

        //Then

    }
    @Test
    public void whenDeletePersonByIdThenReturnOk(){

        //when

        //Then

    }
    @Test
    public void whenDeletePersonByIdThatExistThenReturnError(){

        //when

        //Then

    }
    @Test
    public void whenGetPersonThatExistsThenResultPersonDto(){

        //When

        //Then

    }
    @Test
    public void whenGetPersonThatNotExistsThenResultError(){

        //When

        //Then

    }
}

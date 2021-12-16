package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    @Test
    public void whenAddOnePersonThenResultOk(){

         PersonDto personDto = new PersonDto();
         Integer id = 1;
         String userName = "a";
         String firstName = "b";
         String lastName = "c";
         String email = "d";
         String password = "e";
         String phone = "f";
         Integer userStatus = 2;

         //personService.addOnePerson(personDto);


    }
}

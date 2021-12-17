package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;
import com.example.excercise.entity.Person;
import com.example.excercise.repository.PersonRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


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

        personService.deleteOnePerson(personDto.getId());
    }

    @Test
    public void whenDeleteOnePersonNotFoundThenResultKo(){

    }

    @Test
    public void whenGetPersonByIdThenResultOk(){

    }

    @Test
    public void whenGetPersonByIdNotFoundThenResultKo(){

    }

    @Test
    public void whenGetAllPeopleThenResultOk(){
        //when(personRepository.findAll()).thenReturn(Arrays.asList(personDto));
        assertNotNull(personService.getAllPeople());
    }

    @Test
    public void whenGetAllPeopleIsEmptyThenResultKo(){

    }
}

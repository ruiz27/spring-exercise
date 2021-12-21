package com.example.excercise.controller;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;
import com.example.excercise.repository.PersonRepository;
import com.example.excercise.service.IPersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class PersonApiControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(PersonApiControllerTest.class);

    @Mock
    private MockMvc mockMvc;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonApiController personApiController;

    @Mock
    IPersonService iPersonService;

    private PersonDto personDto;

    @BeforeEach
    public void init() {
        //MockitoAnnotations.initMocks(this);

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
    public void whenGetAllPeopleReturnAllPeople(){

    }

    @Test
    public void whenGetAllPeopleReturnNotFound(){
        /*List<PersonDto> personList = new ArrayList<>();
        Mockito.when(iPersonService.getAllPeople()).thenReturn(List.of(personDto));
        String mvcResult = mockMvc.perform(("/person").contentType("application/json").content(objectMapper.writeValueAsString(personDto)))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();

        logger.info("Response: " + mvcResult);*/



    }

    @Test
    public void whenGetPersonByIdReturnPerson() throws Exception {

    }

    @Test
    public void whenGetPersonByIdReturnNotFound(){

    }

    @Test
    public void whenAddOnePerson() throws Exception {
        Mockito.when(iPersonService.addOnePerson(personDto)).thenReturn((ResponseDto) ResponseEntity.ok());
        String mvcResult = mockMvc.perform(post("/person")
                .contentType("application/json").content(objectMapper.writeValueAsString(personDto)))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();

        logger.info("Response: " + mvcResult);

        assertThat(mvcResult).isEqualTo(personDto);
    }

    @Test
    public void whenDeleteOnePerson(){

    }
}

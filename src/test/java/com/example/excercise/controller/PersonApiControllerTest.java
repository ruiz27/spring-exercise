package com.example.excercise.controller;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;
import com.example.excercise.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {PersonApiController.class})
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest
@RunWith(SpringRunner.class)
public class PersonApiControllerTest {


    private PersonDto personDto1;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private ResponseDto response;

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    PersonService service;


    @Before
    public void init() {
        personDto1 = new PersonDto();
        personDto1.setId(1);
        personDto1.setUsername("test");
        personDto1.setFirstName("test");
        personDto1.setLastName("test");
        personDto1.setEmail("test");
        personDto1.setPassword("test");
        personDto1.setPhone("32452623");
        personDto1.setUserStatus(2);
        personDto1.setId(1);

    }

    @Test
    public void whenGetPeopleList(){
        List<PersonDto> list = new ArrayList<>();
        PersonDto personDto1 = new PersonDto(2,"pluis","pepe","luis","pluis@mail.com","12345","54565434",1);
        list.add(personDto1);
        when(service.getPeopleList()).thenReturn(list);
        try {
            MvcResult mvcResult = mockMvc.perform(get("/v1/person")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(list))).andExpect(status().isOk())
                            .andReturn();

            List<PersonDto> personDtoResult = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);
            assertEquals(list.size(),personDtoResult.size() );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test
    public void whenGetEmptyPeopleList(){
       when(service.getPeopleList()).thenReturn(new ArrayList<>());
        try {
            MvcResult mvcResult = mockMvc.perform(get("/v1/person")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                             .content(objectMapper.writeValueAsString(""))).andExpect(status().isNotFound())
                             .andReturn();
            response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseDto.class);
            Assert.assertEquals(response.getCode(),1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenCreatePerson(){
       when(service.createPerson(ArgumentMatchers.any())).thenReturn(new ResponseDto(4,"La persona se ha añadido a la base de datos"));

        try {
            MvcResult mvcResult = mockMvc.perform(post("/v1/person")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(personDto1))).andExpect(status().isOk())
                    .andReturn();

            response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseDto.class);
            Assert.assertEquals(response.getCode(), 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenDeletePersonById(){
        when(service.deletePersonById(ArgumentMatchers.any())).thenReturn(new ResponseDto(4,"Se ha borrado la persona en persistencia de datos correctamente."));

        try {
            MvcResult mvcResult = mockMvc.perform(delete("/v1/person/{id}","1")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(personDto1))).andExpect(status().isOk())
                    .andReturn();

            response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseDto.class);
            Assert.assertEquals(response.getCode(), 4);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void whenGetPersonThatExists(){
        when(service.getPersonById(ArgumentMatchers.any())).thenReturn(personDto1);

        try {
            MvcResult mvcResult = mockMvc.perform(get("/v1/person/{id}","1")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(personDto1))).andExpect(status().isOk())
                    .andReturn();

            String resultString = mvcResult.getResponse().getContentAsString();
            PersonDto personDtoResult = objectMapper.readValue(resultString,PersonDto.class);
            Assert.assertEquals(personDto1.getFirstName(), personDtoResult.getFirstName());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    public void whenGetPersonThatNotExists(){
        PersonDto personDto15 = new PersonDto();
        when(service.getPersonById(personDto15.getId())).thenReturn(null);

        try {
            MvcResult mvcResult = mockMvc.perform(get("/v1/person/{id}","15")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(personDto15))).andExpect(status().isNotFound())
                            .andReturn();

            String resultString = mvcResult.getResponse().getContentAsString();
            Assert.assertNull(resultString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void whenGetPersonByName(){
        List<PersonDto> list = new ArrayList<>();
        PersonDto personDto2 = new PersonDto(2,"alopez","Antonio","Lopez","pluis@mail.com","12345","54565434",1);
        PersonDto personDto3 = new PersonDto(2,"mantonio","Marco Antonio","Ruiz","pluis@mail.com","12345","54565434",1);

        list.add(personDto2);
        list.add(personDto3);

        when(service.getPersonByName("Antonio")).thenReturn(list);
        try{
            MvcResult mvcResult = mockMvc.perform(get("/v1/person/findByName/{name}", "Antonio")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(list))).andExpect(status().isOk())
                    .andReturn();

            List<PersonDto> personDtoList = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),List.class);
            assertEquals(list.size(), personDtoList.size());
        }catch(Exception e){
          e.printStackTrace();
        }


    }
    @Test
    public void whenGetPersonByNameNotPresent(){
        List<PersonDto> list = new ArrayList<>();
        /*PersonDto personDto2 = new PersonDto(2,"alopez","Antonio","Lopez","pluis@mail.com","12345","54565434",1);
        PersonDto personDto3 = new PersonDto(2,"mantonio","Marco Antonio","Ruiz","pluis@mail.com","12345","54565434",1);

        list.add(personDto2);
        list.add(personDto3);*/

        when(service.getPersonByName(ArgumentMatchers.any())).thenReturn(list);
        try{
            MvcResult mvcResult = mockMvc.perform(get("/v1/person/findByName/{name}", "Antonio")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(list))).andExpect(status().isNotFound())
                    .andReturn();

            List<PersonDto> personDtoList = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),List.class);
            assertTrue(personDtoList.isEmpty());
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}

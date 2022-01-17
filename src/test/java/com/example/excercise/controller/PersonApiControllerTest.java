package com.example.excercise.controller;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;
import com.example.excercise.service.IPersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ContextConfiguration(classes = {PersonApiController.class})
@WebMvcTest()
@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
public class PersonApiControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(PersonApiControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    IPersonService iPersonService;

    private PersonDto personDto;
    private PersonDto personDto1;

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

        personDto1 = new PersonDto();
        personDto1.setId(2);
        personDto1.setPhone("662441317");
        personDto1.setEmail("marina.bencomo@vass.es");
        personDto1.setPassword("marinabencomo");
        personDto1.setUserStatus(1);
        personDto1.setLastName("Bencomo Jorge");
        personDto1.setFirstName("Marina");
        personDto1.setUserName("marina.bencomo");
    }

    @Test
    public void whenGetAllPeopleReturnAllPeople() throws Exception {
        List<PersonDto> personList = new ArrayList<>();
        personList.add(personDto);

        Mockito.when(iPersonService.getAllPeople()).thenReturn(personList);
        MvcResult mvcResult = mockMvc.perform(get("/v1/person")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personList))).andExpect(status().isOk())
                .andReturn();

        List<PersonDto> response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);

        assertEquals(personList.size(), response.size());
    }

    @Test
    public void whenGetAllPeopleReturnNotFound() throws Exception{
        List<PersonDto> personList = new ArrayList<>();
        Mockito.when(iPersonService.getAllPeople()).thenReturn(personList);
        MvcResult mvcResult = mockMvc.perform(get("/v1/person")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personList))).andExpect(status().isNotFound())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();

        assertEquals("",response);
    }

    @Test
    public void whenGetPersonByIdReturnPerson() throws Exception {
       Mockito.when(iPersonService.getPersonById(1)).thenReturn(personDto);

        MvcResult mvcResult = mockMvc.perform(get("/v1/person/{id}","1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personDto))).andExpect(status().isOk())
                .andReturn();

        PersonDto response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), PersonDto.class);

        assertEquals(response.getId(),personDto.getId());
    }

    @Test
    public void whenGetPeopleByNameReturnNotFound() throws Exception{
        List<PersonDto> personList = new ArrayList<>();
        Mockito.when(iPersonService.getPeopleByName("Sonia")).thenReturn(personList);
        MvcResult mvcResult = mockMvc.perform(get("/v1/person")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personList))).andExpect(status().isNotFound())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();

        assertEquals("",response);
    }

    @Test
    public void whenGetPeopleByNameReturnPerson() throws Exception {
        List<PersonDto> personList = new ArrayList<>();
       Mockito.when(iPersonService.getPeopleByName("Sonia")).thenReturn(personList);

        MvcResult mvcResult = mockMvc.perform(get("/v1/person/firstName/{firstName}","Sonia")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personDto))).andExpect(status().isOk())
                .andReturn();

        PersonDto response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), PersonDto.class);

        assertEquals(response.getFirstName(),personDto.getFirstName());
    }

    @Test
    public void whenGetPersonByIdReturnNotFound() throws Exception{
        Mockito.when(iPersonService.getPersonById(ArgumentMatchers.any())).thenReturn(null);

        MvcResult mvcResult = mockMvc.perform(get("/v1/person/{id}","1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personDto)))
                .andExpect(status().isNotFound())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();

        assertEquals("",response);

    }

    @Test
    public void whenAddOnePerson() throws Exception {
        Mockito.when(iPersonService.addOnePerson(ArgumentMatchers.any())).thenReturn(new ResponseDto("Persona creada correctamente.", "OK"));

        MvcResult mvcResult = mockMvc.perform(post("/v1/person")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personDto))).andExpect(status().isOk())
                .andReturn();

        ResponseDto response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseDto.class);

        assertEquals(response.getCode(),"OK");
    }

    @Test
    public void whenDeleteOnePerson() throws Exception {
        Mockito.when(iPersonService.deleteOnePerson(ArgumentMatchers.any())).thenReturn(new ResponseDto("Persona borrada correctamente.", "OK"));

        MvcResult mvcResult = mockMvc.perform(delete("/v1/person/{id}","1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personDto))).andExpect(status().isOk())
                .andReturn();

        ResponseDto response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseDto.class);

        assertEquals(response.getCode(),"OK");

    }
}
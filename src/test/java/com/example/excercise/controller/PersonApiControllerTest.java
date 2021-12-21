package com.example.excercise.controller;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;
import com.example.excercise.service.IPersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest()
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = PersonApiController.class)
public class PersonApiControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(PersonApiControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    IPersonService iPersonService;

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
       /* List<PersonDto> personDtoList = new ArrayList<>();
        personDtoList.add(personDto);

        Mockito.when(iPersonService.getPersonById(1)).thenReturn();
        String mvcResult = mockMvc.perform(get("person/{personId}")
                .contentType("application/json").content(objectMapper.writeValueAsString(personDto)))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();*/


    }

    @Test
    public void whenGetPersonByIdReturnNotFound(){

    }

    @Test
    public void whenAddOnePerson() throws Exception {
        Mockito.when(iPersonService.addOnePerson(personDto)).thenReturn(new ResponseDto("Persona creada correctamente.","OK"));

        String mvcResult = mockMvc.perform(post("/person")
                .contentType("application/json").content(objectMapper.writeValueAsString(personDto)))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();

        ResponseDto response = objectMapper.readValue(mvcResult, ResponseDto.class);

        assertEquals(response.getCode(),"OK");
    }

    @Test
    public void whenDeleteOnePerson(){

    }
}

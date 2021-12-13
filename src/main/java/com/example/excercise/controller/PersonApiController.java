
package com.example.excercise.controller;

import com.example.excercise.api.PersonApi;
import com.example.excercise.dto.PersonDto;
import com.example.excercise.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-10T09:50:17.222Z")

@Controller
public class PersonApiController implements PersonApi {

    private static final Logger log = LoggerFactory.getLogger(PersonApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final PersonService service;

    @org.springframework.beans.factory.annotation.Autowired
    public PersonApiController(ObjectMapper objectMapper, HttpServletRequest request, PersonService service) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.service = service;
    }
    @PostMapping("/person")
    public ResponseEntity<PersonDto> addPerson(@ApiParam(value = "Person object that needs to be added to the databse" ,required=true )  @RequestBody PersonDto body) {
        return new ResponseEntity<PersonDto>(service.postOnePerson(body),HttpStatus.OK);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<PersonDto> deleteOnePerson(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {

        return new ResponseEntity<PersonDto>(service.deleteOnePerson(id), HttpStatus.OK);
    }
    @GetMapping("/person")
    public ResponseEntity<List<PersonDto>> getAllPeople() {
        return new ResponseEntity<List<PersonDto>>(service.getAllPerson(), HttpStatus.OK);
    }
    @GetMapping("/person/{id}")
    public ResponseEntity<PersonDto> getPersonById(@ApiParam(value = "ID of person to return",required=true) @PathVariable("id") Integer id) {
        return new ResponseEntity<PersonDto>(service.getPersonById(id), HttpStatus.OK);
    }

}
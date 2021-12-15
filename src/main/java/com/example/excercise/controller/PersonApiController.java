
package com.example.excercise.controller;

import com.example.excercise.api.PersonApi;
import com.example.excercise.dto.ResponseDto;
import com.example.excercise.dto.PersonDto;
import com.example.excercise.service.PersonService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-10T09:50:17.222Z")

@RestController
public class PersonApiController implements PersonApi {

    private static final Logger log = LoggerFactory.getLogger(PersonApiController.class);
    private final PersonService service;

    public PersonApiController(PersonService service) {
        this.service = service;

    }

    @PostMapping("/person")
    public ResponseEntity<ResponseDto> createPerson(@ApiParam(value = "Person object that needs to be added to the databse" ,required=true )  @RequestBody PersonDto body) {
        return new ResponseEntity<ResponseDto>(service.createPerson(body),HttpStatus.OK);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<ResponseDto> deletePersonById(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        return new ResponseEntity<ResponseDto>(service.deletePersonById(id), HttpStatus.OK);
    }
    @GetMapping("/person")
    public ResponseEntity<List<PersonDto>> getPeopleList() {
        return new ResponseEntity<List<PersonDto>>(service.getPeopleList(), HttpStatus.OK);
    }
    @GetMapping("/person/{id}")
    public ResponseEntity<PersonDto> getPersonById(@ApiParam(value = "ID of person to return",required=true) @PathVariable("id") Integer id) {
        return new ResponseEntity<PersonDto>(service.getPersonById(id), HttpStatus.OK);
    }

}
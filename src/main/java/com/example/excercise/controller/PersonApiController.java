package com.example.excercise.controller;

import com.example.excercise.api.PersonApi;
import com.example.excercise.dto.Person;
import com.example.excercise.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-03T14:05:10.468Z")

@RestController
@Slf4j
public class PersonApiController implements PersonApi {

    private final IPersonService iPersonService;

    public PersonApiController(IPersonService iPersonService) {
        this.iPersonService = iPersonService;
    }

    public ResponseEntity<List<Person>> getAllPeople() {

        return new ResponseEntity<List<Person>>(iPersonService.getAllPeople(),HttpStatus.OK);
    }
}

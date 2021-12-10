package com.example.excercise.controller;

import com.example.excercise.api.PersonApi;
import com.example.excercise.dto.PersonDto;
import com.example.excercise.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Override
    public ResponseEntity<List<PersonDto>> getAllPeople() {
        return new ResponseEntity<List<PersonDto>>(iPersonService.getAllPeople(),HttpStatus.OK);
    }

    @RequestMapping(value = "/person",
            produces = { "application/json", "application/xml" },
            method = RequestMethod.POST)
    public void addPerson(@RequestBody PersonDto personDto) {
        iPersonService.addOnePerson(personDto);
    }

    @RequestMapping(value = "/person",
            produces = { "application/json", "application/xml" },
            method = RequestMethod.DELETE)
    public void deletePerson(@RequestBody PersonDto personDto) {
        iPersonService.deleteOnePerson(personDto);
    }
}

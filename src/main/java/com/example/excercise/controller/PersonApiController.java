package com.example.excercise.controller;

import com.example.excercise.api.PersonApi;
import com.example.excercise.dto.PersonDto;
import com.example.excercise.service.IPersonService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("person/{personId}")
    public ResponseEntity<PersonDto> getPersonById(@ApiParam(value = "ID of person to return",required=true) @PathVariable("personId") Integer id){
        return new ResponseEntity<PersonDto>(iPersonService.getPersonById(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/person",
            produces = { "application/json", "application/xml" },
            method = RequestMethod.POST)
    public void addPerson(@RequestBody PersonDto personDto) {
        iPersonService.addOnePerson(personDto);
    }

    @DeleteMapping("person/{personId}")
    public ResponseEntity<PersonDto> deleteOnePerson(@ApiParam(value = "Person id to delete",required=true) @PathVariable("personId") Integer id){
        return new ResponseEntity<PersonDto>(iPersonService.deleteOnePerson(id),HttpStatus.OK);

    }
}

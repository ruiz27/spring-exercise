package com.example.excercise.controller;

import com.example.excercise.api.PersonApi;
import com.example.excercise.dto.Person;
import com.example.excercise.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-03T12:09:26.656Z")

@RestController
@Slf4j
public class PersonApiController implements PersonApi {
    //inyeccion de dependencia
    private final IPersonService iPersonService;

    public PersonApiController(IPersonService iPersonService) {
        this.iPersonService = iPersonService;
    }

    @Override
    public ResponseEntity<Person> deleteOnePerson() {
        return null;
    }

    @Override
    public ResponseEntity<List<Person>>getAllPeople(){
        //Dentro de controller utilizamos lo que hay en service
        return new ResponseEntity<List<Person>>(iPersonService.getAllPerson(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Person> postOnePerson() {
        return new ResponseEntity<Person>(HttpStatus.OK);
    }

}

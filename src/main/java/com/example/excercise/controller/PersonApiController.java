package com.example.excercise.controller;

import com.example.excercise.api.PersonApi;
import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;
import com.example.excercise.entity.Person;
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
        if(iPersonService.getAllPeople().isEmpty()){
            return new ResponseEntity<List<PersonDto>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<PersonDto>>(iPersonService.getAllPeople(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonDto>> getPeopleByName(String userName) {
        if(iPersonService.getPeopleByName().isEmpty()){
            return new ResponseEntity<List<PersonDto>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<PersonDto>>(iPersonService.getPeopleByName(), HttpStatus.OK);
    }

    public ResponseEntity<PersonDto> getPersonById(@ApiParam(value = "ID of person to return",required=true) @PathVariable("personId") Integer id){
        PersonDto personDto = iPersonService.getPersonById(id);
        if(personDto == null){
            return new ResponseEntity<PersonDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PersonDto>(personDto, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto> addOnePerson(PersonDto personDto) {
        return new ResponseEntity<ResponseDto>(iPersonService.addOnePerson(personDto),HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto> deleteOnePerson(@ApiParam(value = "Person id to delete",required=true) @PathVariable("personId") Integer id){
        return new ResponseEntity<ResponseDto>(iPersonService.deleteOnePerson(id),HttpStatus.OK);

    }
}


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
import java.io.IOException;
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
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<PersonDto>(objectMapper.readValue("<null>  <id>123456789</id>  <username>aeiou</username>  <firstName>aeiou</firstName>  <lastName>aeiou</lastName>  <email>aeiou</email>  <password>aeiou</password>  <phone>aeiou</phone>  <userStatus>123</userStatus></null>", PersonDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<PersonDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PersonDto>(objectMapper.readValue("{\"empty\": false}", PersonDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PersonDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PersonDto>(HttpStatus.NOT_IMPLEMENTED);
    }
    @DeleteMapping("/person/{id}")
    public ResponseEntity<PersonDto> deleteOnePerson(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {

        return new ResponseEntity<PersonDto>(service.deleteOnePerson(), HttpStatus.OK);
    }
    @GetMapping("/person")
    public ResponseEntity<PersonDto> getAllPeople() {
        return new ResponseEntity<PersonDto>(service.getAllPerson(), HttpStatus.OK);//definir en swagger que devuelve lista
    }

    public ResponseEntity<PersonDto> getPersonById(@ApiParam(value = "ID of person to return",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<PersonDto>(objectMapper.readValue("<null>  <id>123456789</id>  <username>aeiou</username>  <firstName>aeiou</firstName>  <lastName>aeiou</lastName>  <email>aeiou</email>  <password>aeiou</password>  <phone>aeiou</phone>  <userStatus>123</userStatus></null>", PersonDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<PersonDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PersonDto>(objectMapper.readValue("{\"empty\": false}", PersonDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PersonDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PersonDto>(HttpStatus.NOT_IMPLEMENTED);
    }

}
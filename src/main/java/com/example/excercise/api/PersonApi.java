
package com.example.excercise.api;

import com.example.excercise.dto.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-07T07:14:06.685Z")

@Validated
@Api(value = "person", description = "the person API")
@RequestMapping(value = "/v1")
public interface PersonApi {

    @ApiOperation(value = "Delete one people in database", nickname = "deleteOnePerson", notes = "", response = Person.class, tags={ "person", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Person.class),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/person",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Person> deleteOnePerson();





    @ApiOperation(value = "Add one people in database", nickname = "postOnePerson", notes = "", response = Person.class, tags={ "person", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Person.class),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/person",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.POST)
    ResponseEntity<Person> postOnePerson();

    @ApiOperation(value = "Get all people in database", nickname = "getAllPeople", notes = "", response = List.class, tags={ "person", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Person.class),
            @ApiResponse(code = 400, message = "Invalid username supplied"),
            @ApiResponse(code = 404, message = "User not found") })
            @RequestMapping(value = "/person",
            produces = { "application/json", "application/xml" },
            method = RequestMethod.GET)
    ResponseEntity<List<Person>>getAllPeople();

}

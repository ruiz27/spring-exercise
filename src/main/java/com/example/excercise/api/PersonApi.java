

package com.example.excercise.api;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-10T09:50:17.222Z")

@Validated
@Api(value = "person", description = "the person API")
@RequestMapping(value = "/v1")
public interface PersonApi {

    @ApiOperation(value = "Add a new person to the persistance", nickname = "addPerson", notes = "", response = PersonDto.class, tags={ "person", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = PersonDto.class),
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/person",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ResponseDto> createPerson(@ApiParam(value = "Person object that needs to be added to the databse" ,required=true )   @RequestBody PersonDto personDto);


    @ApiOperation(value = "Delete a person by id", nickname = "deleteOnePerson", notes = "", response = PersonDto.class, tags={ "person", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = PersonDto.class),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Person not found") })
    @RequestMapping(value = "/person/{id}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<ResponseDto> deletePersonById(@ApiParam(value = "",required=true) @PathVariable("id") Integer id);


    @ApiOperation(value = "Get all people from database", nickname = "getAllPeople", notes = "", response = List.class, tags={ "person", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = PersonDto.class),
            @ApiResponse(code = 400, message = "Invalid list supplied"),
            @ApiResponse(code = 404, message = "List not found") })
    @RequestMapping(value = "/person",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<PersonDto>> getPeopleList();


    @ApiOperation(value = "Find person by ID", nickname = "getPersonById", notes = "Returns a single person", response = PersonDto.class, tags={ "person", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = PersonDto.class),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Person not found") })
    @RequestMapping(value = "/person/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<PersonDto> getPersonById(@ApiParam(value = "ID of person to return",required=true) @PathVariable("id") Integer id);


    @ApiOperation(value = "Find person by Name", nickname = "getPersonByName", notes = "Returns a single person", response = PersonDto.class, tags={ "person", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = PersonDto.class),
            @ApiResponse(code = 400, message = "Invalid Name supplied"),
            @ApiResponse(code = 404, message = "Person not found") })
    @RequestMapping(value = "/person/findByName/{name}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<PersonDto>> getPersonByName(@ApiParam(value = "Name of person to return",required=true) @PathVariable("name") String name);
}

package com.example.excercise.api;

import com.example.excercise.dto.PersonDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-03T14:05:10.468Z")

@Validated
@Api(value = "person", description = "the person API")
@RequestMapping(value = "/v1")
public interface PersonApi {

    @ApiOperation(value = "Get one people in database", nickname = "getAllPeople", notes = "", response = List.class, tags={ "person", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = PersonDto.class),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found") })

    @RequestMapping(value = "/person",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PersonDto>> getAllPeople();

    @RequestMapping(value = "/person/{personId}",
            produces = { "application/json", "application/xml" },
            method = RequestMethod.GET)
    ResponseEntity<PersonDto> getPersonById(@ApiParam(value = "ID of person to return", required = true) @PathVariable("id") Integer id);

    @RequestMapping(value = "/person",
            produces = { "application/json", "application/xml" },
            method = RequestMethod.POST)
    void addPerson(@RequestBody PersonDto personDto);

    @RequestMapping(value = "/person/{personId}",
            produces = { "application/json", "application/xml" },
            method = RequestMethod.DELETE)
    ResponseEntity<PersonDto> deleteOnePerson(@ApiParam(value = "Person id to delete", required = true) @PathVariable("id") Integer id);
}

package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;

import java.util.List;

public interface IPersonService {
    List<PersonDto> getAllPeople();
    PersonDto getPersonById(Integer id);
    ResponseDto addOnePerson(PersonDto personDto);
    ResponseDto deleteOnePerson(Integer id);
}

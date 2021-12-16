package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.dto.ResponseDto;

import java.util.List;

public interface IPersonService {
    List<PersonDto> getPeopleList();
    ResponseDto createPerson(PersonDto personDto);
    ResponseDto deletePersonById(Integer id);
    PersonDto getPersonById(Integer id);
}

package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;

import java.util.List;

public interface IPersonService {
    List<PersonDto> getAllPeople();
    PersonDto getPersonById(Integer id);
    void addOnePerson(PersonDto personDto);
    PersonDto deleteOnePerson(Integer id);
}

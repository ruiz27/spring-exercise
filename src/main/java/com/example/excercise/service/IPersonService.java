package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;

import java.util.List;

public interface IPersonService {
    List<PersonDto> getAllPerson();
    PersonDto postOnePerson(PersonDto body);
    PersonDto deleteOnePerson(Integer id);
    PersonDto getPersonById(Integer id);
}

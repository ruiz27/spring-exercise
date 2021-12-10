package com.example.excercise.service;

import com.example.excercise.dto.PersonDto;

import java.util.List;

public interface IPersonService {
    public List<PersonDto> getAllPeople();

    void addOnePerson(PersonDto personDto);

    void deleteOnePerson(PersonDto personDto);
}

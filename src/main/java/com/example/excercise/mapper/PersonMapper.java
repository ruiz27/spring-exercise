package com.example.excercise.mapper;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface PersonMapper {

    PersonMapper INSTANCIA = Mappers.getMapper((PersonMapper.class));

    PersonDto personToPersonDto(Person person);
    Person personDtoToPerson(PersonDto personDto);
}
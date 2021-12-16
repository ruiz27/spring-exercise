package com.example.excercise.mapper;

import org.mapstruct.factory.Mappers;
import com.example.excercise.dto.PersonDto;
import com.example.excercise.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface PersonMapper {

    PersonMapper INSTANCIA = Mappers.getMapper((PersonMapper.class));
    PersonDto personToPersonDto(Person person);
    Person personDtoToPerson(PersonDto personDto);
}


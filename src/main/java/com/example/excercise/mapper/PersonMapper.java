package com.example.excercise.mapper;

import com.example.excercise.entity.PersonAttributes;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import com.example.excercise.dto.PersonDto;
import com.example.excercise.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface PersonMapper {

    PersonMapper INSTANCIA = Mappers.getMapper((PersonMapper.class));

    @Mapping(source = "attributes.idAttributes", target = "idAttributes")

    PersonDto personToPersonDto(Person person);
    Person personDtoToPerson(PersonDto personDto);
}


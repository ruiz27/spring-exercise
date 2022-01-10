package com.example.excercise.mapper;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//Etiqueta "uses" para invocar el mapeo para el objeto que tiene el primer objeto person
@Mapper(componentModel = "Spring", uses = PersonAttributeMapper.class)
public interface PersonMapper {


    @Mapping(source="firstname", target="firstName")
    @Mapping(source="lastname", target="lastName")
    @Mapping(source="userstatus", target = "userStatus")
    PersonDto personToPersonDto(Person person);


    @Mapping(source="firstName", target="firstname")
    @Mapping(source="lastName", target="lastname")
    @Mapping(source="userStatus", target = "userstatus")
    Person personDtoToPerson(PersonDto personDto);

}
package com.example.excercise.mapper;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//Posible uso etiqueta uses para mapear objetos dentro de objetos
@Mapper(componentModel = "Spring")
public interface PersonMapper {


    @Mapping(source="person.firstname", target="firstName")
    @Mapping(source="person.lastname", target="lastName")
    @Mapping(source="person.userstatus", target = "userStatus")
    @Mapping(source = "idAttribute.id", target ="idAttribute")
    PersonDto personToPersonDto(Person person);


    @Mapping(source="firstName", target="firstname")
    @Mapping(source="lastName", target="lastname")
    @Mapping(source="userStatus", target = "userstatus")
    @Mapping(source = "personDto.idAttribute", target = "idAttribute.id")
    Person personDtoToPerson(PersonDto personDto);

}
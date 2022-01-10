package com.example.excercise.mapper;

import com.example.excercise.dto.PersonAttributeDto;
import com.example.excercise.entities.PersonAttribute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface PersonAttributeMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "idAttribute", target = "idAttribute", ignore = false)
    @Mapping(source = "attribute", target = "attribute", ignore = false)
    PersonAttribute personAttributeDtoTopersonAttribute( PersonAttributeDto personAttributeDto);

    //Mapeo utilizado por la clase padre "PersonMapper" para mapear objeto dentro de objeto
    /*@Mapping(source = "id", target = "id")
    @Mapping(source = "idAttribute", target = "idAttribute", ignore = false)
    @Mapping(source = "attribute", target = "attribute", ignore = false)
    PersonAttributeDto personAttributeToPersonAttributeDto (PersonAttribute personAttribute);*/

    //Metodo default para settear los atributos del objeto dentro del objeto (resto en null)
    default PersonAttributeDto personToPersonDtoWithIdAttribute(PersonAttribute personAttribute){
        PersonAttributeDto personAttributeDto = new PersonAttributeDto();
        personAttributeDto.setId(personAttribute.getId());
        return personAttributeDto;
    }
}

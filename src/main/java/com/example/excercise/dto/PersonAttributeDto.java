package com.example.excercise.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PersonAttributeDto implements Serializable {

    @JsonProperty( "id")
    private Integer id;
    @JsonProperty("idattribute")
    private int idAttribute;
    @JsonProperty( "attribute")
    private String attribute;

    public PersonAttributeDto() {
    }

}

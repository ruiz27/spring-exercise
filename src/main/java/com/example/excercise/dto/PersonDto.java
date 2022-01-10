package com.example.excercise.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-09T11:32:42.208Z")

@Getter
@Setter
public class PersonDto {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("userstatus")
  private Integer userStatus = null;

  @JsonProperty("id_attribute_id")
  private Integer idAttribute = null;

  public PersonDto() {

  }

  public PersonDto(Integer id, String username, String firstName, String lastName, String email, String password, String phone, Integer userStatus) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.userStatus = userStatus;
  }
}


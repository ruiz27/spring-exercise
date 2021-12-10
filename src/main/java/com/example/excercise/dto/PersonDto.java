package com.example.excercise.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;


@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-09T11:32:42.208Z")


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

  @JsonProperty("userStatus")
  private Integer userStatus = null;

  public PersonDto id(Integer id) {
    this.id = id;
    return this;
  }


  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PersonDto username(String username) {
    this.username = username;
    return this;
  }


  @ApiModelProperty(value = "")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public PersonDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }


  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public PersonDto lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }


  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public PersonDto email(String email) {
    this.email = email;
    return this;
  }


  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public PersonDto password(String password) {
    this.password = password;
    return this;
  }


  @ApiModelProperty(value = "")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public PersonDto phone(String phone) {
    this.phone = phone;
    return this;
  }


  @ApiModelProperty(value = "")


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public PersonDto userStatus(Integer userStatus) {
    this.userStatus = userStatus;
    return this;
  }


  @ApiModelProperty(value = "User Status")


  public Integer getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Integer userStatus) {
    this.userStatus = userStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonDto person = (PersonDto) o;
    return Objects.equals(this.id, person.id) &&
        Objects.equals(this.username, person.username) &&
        Objects.equals(this.firstName, person.firstName) &&
        Objects.equals(this.lastName, person.lastName) &&
        Objects.equals(this.email, person.email) &&
        Objects.equals(this.password, person.password) &&
        Objects.equals(this.phone, person.phone) &&
        Objects.equals(this.userStatus, person.userStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, firstName, lastName, email, password, phone, userStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }


  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


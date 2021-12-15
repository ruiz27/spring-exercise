package com.example.excercise.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter@Setter
@Entity
@Table(name="Person")
public class Person implements Serializable {
    @Id
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private Integer userstatus;

    public Person() {
    }
}

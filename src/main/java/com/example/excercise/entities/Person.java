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

    public Person(Integer id, String username, String firstname, String lastname, String email, String password, String phone, Integer userstatus) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userstatus = userstatus;
    }
}

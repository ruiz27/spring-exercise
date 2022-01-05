package com.example.excercise.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter@Setter
@Entity
@Table(name="Person")
public class Person implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "jhi_password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "userStatus")
    private Integer userstatus;

    @OneToOne
    @JoinColumn( name = "id_attribute_id" , unique = true)
    private PersonAttribute idAttribute;

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

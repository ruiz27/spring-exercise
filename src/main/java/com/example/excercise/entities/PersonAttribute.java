package com.example.excercise.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name="person_attribute")
public class PersonAttribute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idattribute")
    private int idAttribute;
    @Column(name = "attribute")
    private String attribute;

    public PersonAttribute() {
    }
}

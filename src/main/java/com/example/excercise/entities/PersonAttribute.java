package com.example.excercise.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="PersonAttribute")
public class PersonAttribute {

    private int id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAttribute;
    private String attribute;

    public PersonAttribute() {
    }
}

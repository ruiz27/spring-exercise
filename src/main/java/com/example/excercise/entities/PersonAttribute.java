package com.example.excercise.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name="PersonAttribute")
public class PersonAttribute {

    @Id
    @Column(name = "idAttribute")
    private int idAttribute;
    @Column(name = "attribute")
    private String attribute;

    @OneToOne(mappedBy = "personAttribute", fetch = FetchType.LAZY)
    private Person person;

    public PersonAttribute() {
    }
}

package com.example.excercise.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name="PersonAttribute")
public class PersonAttribute implements Serializable {

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

package com.example.excercise.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "person_attributes")
public class PersonAttributes {
    @Id
    @Column(name = "id_attributes")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAttributes;

    @Column(name = "age")
    private String age;

    @Column(name = "weight")
    private String weight;

    @Column(name = "height")
    private String height;

    @Column(name = "nationality")
    private String nationality;

}

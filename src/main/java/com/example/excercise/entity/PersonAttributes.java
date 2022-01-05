package com.example.excercise.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PersonAttributes")
public class PersonAttributes {
    @Id
    @Column(name = "id_attributes")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_attributes;

    @Column(name = "age")
    private String age;

    @Column(name = "weight")
    private String weight;

    @Column(name = "height")
    private String height;

    @Column(name = "nationality")
    private String nationality;

    @OneToOne(mappedBy = "attributes", fetch = FetchType.LAZY)
    private Person person;

}

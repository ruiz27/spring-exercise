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

    private String age;
    private String weight;
    private String height;
    private String nationality;

    @OneToOne(mappedBy = "attributes", fetch = FetchType.LAZY)
    private Person person;

}

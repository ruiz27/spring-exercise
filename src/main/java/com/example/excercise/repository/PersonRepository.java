package com.example.excercise.repository;

import com.example.excercise.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Repositorios solo trabajan con entidades

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}

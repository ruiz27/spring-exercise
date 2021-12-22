package com.example.excercise.repository;


import com.example.excercise.entities.PersonAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonAttributeRespository extends JpaRepository<PersonAttribute, Integer> {
}
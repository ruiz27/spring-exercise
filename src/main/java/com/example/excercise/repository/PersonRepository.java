package com.example.excercise.repository;

import com.example.excercise.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Transactional(readOnly = true)
    List<Person> findByUsernameContaining (String username);
}

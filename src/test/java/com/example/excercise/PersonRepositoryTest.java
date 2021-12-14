/*package com.example.excercise;

import com.example.excercise.dto.PersonDto;
import com.example.excercise.entities.Person;
import com.example.excercise.repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PersonRepositoryTest {
    private final PersonRepository personRepository;

    public PersonRepositoryTest(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Test
    public void postOnePerson(){
        Person person = Person.builder()
                .id(100005)
                .username("dlopez")
                .firstname("Daniel")
                .lastname("Lopez")
                .email("dlopez@gmial.com")
                .password("9876")
                .phone("675897690")
                .userstatus(1)
                .build();
        personRepository.save(person);
        Assertions.assertThat(person.getId()).isGreaterThan(10004);
    }
}*/

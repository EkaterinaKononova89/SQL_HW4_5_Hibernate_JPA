package ru.netology.SQL_HW4_5_Hibernate_JPA.controller;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.SQL_HW4_5_Hibernate_JPA.entity.Persons;
import ru.netology.SQL_HW4_5_Hibernate_JPA.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam String city) {
        return repository.findByCityOfLiving(city);
    }

    @GetMapping("/persons/by-age")
    public List<Persons> getPersonsByAge(@RequestParam int age) {
        return repository.findByUniqueInfo_AgeLessThan(age, Sort.by(Sort.Direction.ASC, "uniqueInfo.age"));
//        return repository.findByUniqueInfo_AgeLessThanOrderByUniqueInfo_Age(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<Persons> getPersonsByNameAndSurname(@RequestParam String name, String surname) {
        return repository.findByUniqueInfo_NameAndUniqueInfo_Surname(name, surname);
    }
}

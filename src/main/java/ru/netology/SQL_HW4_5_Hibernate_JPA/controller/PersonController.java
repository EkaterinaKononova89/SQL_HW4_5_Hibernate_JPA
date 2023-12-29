package ru.netology.SQL_HW4_5_Hibernate_JPA.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.SQL_HW4_5_Hibernate_JPA.entity.Persons;
import ru.netology.SQL_HW4_5_Hibernate_JPA.repository.PersonRepository;

import java.util.List;

public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }
}

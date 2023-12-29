package ru.netology.SQL_HW4_5_Hibernate_JPA.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.SQL_HW4_5_Hibernate_JPA.entity.Persons;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    // многопоточный @Autowire; @PersistenceContext умеет инжектировать только напрямую в поле, без конструктора
    private EntityManager entityManager;

    public List<Persons> getPersonsByCity(String city) {

        return entityManager.createQuery("SELECT p FROM Persons p WHERE p.cityOfLiving LIKE :requiredCity") // запрос на HQL (Hibernate Query Language)
                .setParameter("requiredCity", city)
                .getResultList();
    }
}

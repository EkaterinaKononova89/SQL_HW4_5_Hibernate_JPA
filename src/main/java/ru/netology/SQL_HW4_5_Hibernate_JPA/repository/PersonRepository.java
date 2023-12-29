package ru.netology.SQL_HW4_5_Hibernate_JPA.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.SQL_HW4_5_Hibernate_JPA.entity.PersonUniqueInfo;
import ru.netology.SQL_HW4_5_Hibernate_JPA.entity.Persons;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Persons, PersonUniqueInfo> {
    List<Persons> findByCityOfLiving(String city);

    // метод, который принимает возраст (age) и возвращает Entity из БД, которые меньше переданного age и отсортированы по возрастанию
    @Query("SELECT p FROM Persons p WHERE p.uniqueInfo.age < :age")
    List<Persons> findByUniqueInfo_AgeLessThan(@Param("age") Integer age, Sort sort);
    //или так:
    //@Query("SELECT p FROM Persons p WHERE p.uniqueInfo.age < :age ORDER BY p.uniqueInfo.age")
    //List<Persons> findByUniqueInfo_AgeLessThanOrderByUniqueInfo_Age(@Param("age") Integer age);


    // метод, который принимает имя и фамилию (name и surname) и возвращает Entity из БД, которые соответствуют сочетанию name и surname
    @Query("SELECT p FROM Persons p WHERE p.uniqueInfo.name = :name AND p.uniqueInfo.surname = :surname ")
    Optional<Persons> findByUniqueInfo_NameAndUniqueInfo_Surname(@Param("name") String name, @Param("surname") String surname);
}

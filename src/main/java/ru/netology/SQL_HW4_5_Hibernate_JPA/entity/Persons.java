package ru.netology.SQL_HW4_5_Hibernate_JPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor // пустой конструктор, необходим для работы Hibernate
@Table(schema = "netology")
public class Persons {
    @EmbeddedId
    private PersonUniqueInfo uniqueInfo;
    @Column(nullable = false, name = "phone_number", unique = true)
    private String phoneNumber;
    @Column(nullable = false, name = "city_of_living")
    private String cityOfLiving;

    // public Persons() {} - создается аннотацией @NoArgsConstructor
}

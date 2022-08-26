package com.learningRestfulSpringboot.SimpleCRUD.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Entity(name="Student")
@Table(name="student")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
            name="name",
            nullable = false,
            length = 100,
            columnDefinition = "Text"
    )
    private String name;

    @NaturalId
    @Column(
            name="email",
            nullable = false,
            length = 110,
            columnDefinition = "Text",
            unique = true)
    private String email;

    @Column(
            name="age",
            length = 100,
            nullable = false
    )
    @Transient
    private Integer age;

    @Column(
            name="created_at",
            nullable = false,
            updatable = false
    )
    private LocalDate createdAt;

    public Integer getAge(){
        return Period.between(createdAt,LocalDate.now()).getYears()+age;
    }
    public Student(String name, String email, Integer age, LocalDate createdAt) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.createdAt = createdAt;
    }
}

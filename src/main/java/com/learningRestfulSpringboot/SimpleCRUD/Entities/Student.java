package com.learningRestfulSpringboot.SimpleCRUD.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Setter
@Getter
@Entity(name="Student")
@Table(name="student")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",updatable = false)
    private Long id;

    @Column(name="name",nullable = false,columnDefinition = "Text")
    private String name;

    @Column(name="email",nullable = false,columnDefinition = "Text")
    private String email;

    @Column(name="age")
    @Transient
    private Integer age;

    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
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

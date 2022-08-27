package com.restfulSpringboot.JpaHibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique",columnNames = "email")}
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "email",nullable = false,length = 60)
    private String email;

    @Column(name = "age",nullable = false)
    private Short age;

    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDate createdAt;

    //relation link to student_card one to one
    @OneToOne(
            mappedBy = "student", //name on the otherside
            orphanRemoval = true, //cascade on
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    private StudentCard studentCard;

    //relation link to book one to many
    @OneToMany(
            mappedBy = "student",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY //fecth for list
    )
    private List<Book> book = new ArrayList<>();

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

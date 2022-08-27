package com.restfulSpringboot.JpaHibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //book.student_id > student.id
    @ManyToOne (fetch = FetchType.LAZY)
    private Student student;

    @Column(name = "book_name",nullable = false,length = 100)
    private String bookName;

    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDate createdAt;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", student=" + student +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}

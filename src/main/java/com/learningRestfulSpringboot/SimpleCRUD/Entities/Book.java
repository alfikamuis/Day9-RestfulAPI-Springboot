package com.learningRestfulSpringboot.SimpleCRUD.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity(name="Book")
@Table(name="book")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    //@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "book_name")
    @Column(
            name = "book_name",
            nullable = false,
            columnDefinition = "Text"
    )
    private Integer bookName;

    @Column(
            name="created_at",
            nullable = false,
            updatable = false
    )
    private LocalDate createdAt;

    public Book(Integer bookName, LocalDate createdAt) {
        this.bookName = bookName;
        this.createdAt = createdAt;
    }
}

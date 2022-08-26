package com.learningRestfulSpringboot.SimpleCRUD.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity(name="StudentCard")
@Table(name="student_card")
public class StudentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Integer studentId;

    @Column(name="card_number",nullable = false,columnDefinition = "Text")
    private String cardNumber;

}

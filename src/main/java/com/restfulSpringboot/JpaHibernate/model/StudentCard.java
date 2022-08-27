package com.restfulSpringboot.JpaHibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "student_card",
        uniqueConstraints = {
            @UniqueConstraint(name = "card_number_unique",columnNames = "card_number")}
)
public class StudentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //One to one student_card.student_id - student.id
    //if student.id deleted, student_card with same student_id also cascade
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn( //join because as extends information of the student class
            name = "student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "Student_card_id_fk")
    )
    private Student student;

    @Column(name = "card_number",nullable = false,length = 100)
    private String cardNumber;

}

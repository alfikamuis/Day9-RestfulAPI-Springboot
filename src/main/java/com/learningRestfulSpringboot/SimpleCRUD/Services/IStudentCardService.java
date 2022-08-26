package com.learningRestfulSpringboot.SimpleCRUD.Services;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.StudentCard;

import java.util.List;

public interface IStudentCardService {
    List<StudentCard> findAllStudentCard();

    void deleteStudentCard(Long id);

    void updateCardNumberById(Long studentId, String cardNumber);
}

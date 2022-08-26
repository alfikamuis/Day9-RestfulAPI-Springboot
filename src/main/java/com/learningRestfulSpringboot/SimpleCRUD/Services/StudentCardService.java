package com.learningRestfulSpringboot.SimpleCRUD.Services;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.StudentCard;
import com.learningRestfulSpringboot.SimpleCRUD.Repositories.StudentCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCardService implements IStudentCardService{

    @Autowired
    private final StudentCardRepository studentCardRepository;

    @Autowired
    public StudentCardService(StudentCardRepository studentCardRepository) {
        this.studentCardRepository = studentCardRepository;
    }

    @Override
    public List<StudentCard> findAllStudentCard(){
        return studentCardRepository.findAll();
    }

    @Override
    public void deleteStudentCard(Long id){
        studentCardRepository.deleteById(id);
    }


    public void updateCardNumberById(Long studentId, String cardNumber){
        if(studentCardRepository.findById(studentId).isPresent()){
           StudentCard newStudent = studentCardRepository.findById(studentId).get();
           newStudent.setCardNumber(cardNumber);
           studentCardRepository.save(newStudent);
        }
    }
}

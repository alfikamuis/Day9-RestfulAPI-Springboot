package com.restfulSpringboot.JpaHibernate.service;

import com.restfulSpringboot.JpaHibernate.dto.StudentCardDTO;
import com.restfulSpringboot.JpaHibernate.model.StudentCard;
import com.restfulSpringboot.JpaHibernate.repository.StudentCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCardServiceImp implements StudentCardService{

    @Autowired
    StudentCardRepository studentCardRepository;
    @Override
    public List<StudentCard> findCardAll() {
        return studentCardRepository.findAll();
    }

    @Override
    public StudentCard findCardById(Long id) {
        Optional<StudentCard> result = studentCardRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    @Override
    public StudentCard addCard(Long id, StudentCard studentCard) {
        StudentCard result = findCardById(id);
        if(result != null){
            result.setCardNumber(studentCard.getCardNumber());
            return studentCardRepository.save(studentCard);
        }
        return null;
    }

    @Override
    public StudentCardDTO mapToDto(StudentCard studentCard) {
        return null;
    }

    @Override
    public StudentCard mapToEntity(StudentCardDTO studentCardDTO) {
        return null;
    }
}

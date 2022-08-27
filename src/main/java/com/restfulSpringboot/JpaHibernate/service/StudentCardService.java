package com.restfulSpringboot.JpaHibernate.service;

import com.restfulSpringboot.JpaHibernate.dto.BookDTO;
import com.restfulSpringboot.JpaHibernate.dto.StudentCardDTO;
import com.restfulSpringboot.JpaHibernate.model.Book;
import com.restfulSpringboot.JpaHibernate.model.StudentCard;

import java.util.List;

public interface StudentCardService {

    List<StudentCard> findCardAll();
    StudentCard findCardById(Long id);
    StudentCard addCard(Long id,StudentCard studentCard);

    StudentCardDTO mapToDto(StudentCard studentCard);
    StudentCard mapToEntity(StudentCardDTO studentCardDTO);
}

package com.restfulSpringboot.JpaHibernate.service;

import com.restfulSpringboot.JpaHibernate.dto.StudentDTO;
import com.restfulSpringboot.JpaHibernate.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    Student findById(Long id);
    Student add(Student student);
    Student update(Long id,Student student);
    Boolean delete(Long id);

    StudentDTO mapToDto(Student student);
    Student mapToEntity(StudentDTO studentDTO);

}

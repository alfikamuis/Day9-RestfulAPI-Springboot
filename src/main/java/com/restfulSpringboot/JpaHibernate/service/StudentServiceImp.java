package com.restfulSpringboot.JpaHibernate.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restfulSpringboot.JpaHibernate.dto.StudentDTO;
import com.restfulSpringboot.JpaHibernate.model.Student;
import com.restfulSpringboot.JpaHibernate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImp implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> result = studentRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    @Override
    public Student add(Student student) {
        student.setCreatedAt(LocalDate.now());
        return studentRepository.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        //Optional<Student> email = studentRepository.findByEmail(student.getEmail());
        //if(email.isPresent()){
        //    throw new IllegalStateException("email already exist!");
        //}
        Student result = findById(id);
        if(result != null){
            result.setName(student.getName());
            result.setEmail(student.getEmail());
            student.setCreatedAt(LocalDate.now());
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Student result = findById(id);
        if (result != null){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public StudentDTO mapToDto(Student student) {
        return mapper.convertValue(student, StudentDTO.class);
    }

    @Override
    public Student mapToEntity(StudentDTO studentDTO) {
        return mapper.convertValue(studentDTO, Student.class);
    }
}

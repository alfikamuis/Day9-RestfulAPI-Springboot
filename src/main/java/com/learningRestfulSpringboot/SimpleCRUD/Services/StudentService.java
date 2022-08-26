package com.learningRestfulSpringboot.SimpleCRUD.Services;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.Student;
import com.learningRestfulSpringboot.SimpleCRUD.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository =studentRepository;
    }

    public List<Student> getStudent () {
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        Optional<Student> checkEmail = studentRepository.findByEmail(student.getEmail());
        if(checkEmail.isPresent()){
            throw new IllegalStateException("email already exist!");
        }
        studentRepository.save(student);
    }
}

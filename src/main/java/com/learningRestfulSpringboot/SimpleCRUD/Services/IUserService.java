package com.learningRestfulSpringboot.SimpleCRUD.Services;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.Student;

import java.util.Optional;

public interface IUserService {
    //show student by Id
    Optional<Student> getStudentById(Long id);

    //show student by name
    Optional<Student> getStudentByName(String name);
}

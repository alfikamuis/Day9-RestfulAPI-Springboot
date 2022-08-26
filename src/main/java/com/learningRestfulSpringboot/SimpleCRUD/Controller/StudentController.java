package com.learningRestfulSpringboot.SimpleCRUD.Controller;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.Student;
import com.learningRestfulSpringboot.SimpleCRUD.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/student")
    public List<Student> getAllStudent (){
        return studentService.getStudent();
    }

    @PostMapping("/student")
    public void registerStudent (@RequestBody Student student){
        studentService.addStudent(student);
    }

}

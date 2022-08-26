package com.learningRestfulSpringboot.SimpleCRUD.Controller;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.Student;
import com.learningRestfulSpringboot.SimpleCRUD.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/student") //tampil semua
    public ResponseEntity<?> getAllStudent (){
        return new ResponseEntity<>(studentService.getStudent(),HttpStatus.OK);
    }

    @GetMapping("/student/{id}") //tampil sesuai id
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping("/student/{name}") //tampil sesuai nama
    public ResponseEntity<?> getStudentByName(@PathVariable String name){
        return new ResponseEntity<>(studentService.getStudentByName(name), HttpStatus.OK);
    }

    @PostMapping("/student") //tambah student
    public ResponseEntity<?> registerStudent (@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{id}") //hapus berdasarkan id
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

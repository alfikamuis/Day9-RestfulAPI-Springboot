package com.restfulSpringboot.JpaHibernate.controller;

import com.restfulSpringboot.JpaHibernate.dto.StudentDTO;
import com.restfulSpringboot.JpaHibernate.model.Student;
import com.restfulSpringboot.JpaHibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/student")
    public List<StudentDTO> findAll(){
        return studentService.findAll()
                .stream()
                .map(student -> studentService.mapToDto(student))
                .collect(Collectors.toList()
                );
    }

    @GetMapping(value = "/student/{id}")
    public StudentDTO findById(@PathVariable Long id){
        final Student result = studentService.findById(id);
        return studentService.mapToDto(result);
    }

    @PostMapping(value = "/student/add")
    public StudentDTO add(@RequestBody StudentDTO request){
        final Student studentRequest = studentService.mapToEntity(request);
        final Student result = studentService.add(studentRequest);
        return studentService.mapToDto(result);
    }

    @PutMapping(value = "/student/update/{id}")
    public StudentDTO update(@PathVariable Long id,@RequestBody StudentDTO request){
        final Student studentRequest = studentService.mapToEntity(request);
        final Student result = studentService.update(id,studentRequest);
        return studentService.mapToDto(result);
    }

    @DeleteMapping(value = "/student/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return studentService.delete(id);
    }
}

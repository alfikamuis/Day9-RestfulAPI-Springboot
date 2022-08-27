package com.restfulSpringboot.JpaHibernate.controller;

import com.restfulSpringboot.JpaHibernate.dto.StudentDTO;
import com.restfulSpringboot.JpaHibernate.model.Student;
import com.restfulSpringboot.JpaHibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(name = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<StudentDTO> findAll(){
        return studentService.findAll()
                .stream()
                .map(student -> studentService.mapToDto(student))
                .collect(Collectors.toList()
                );
    }

    @GetMapping(name = "{id}")
    public StudentDTO findById(@PathVariable Long id){
        final Student result = studentService.findById(id);
        return studentService.mapToDto(result);
    }

    @PostMapping(name = "add")
    public StudentDTO add(@RequestBody StudentDTO request){
        final Student studentRequest = studentService.mapToEntity(request);
        final Student result = studentService.add(studentRequest);
        return studentService.mapToDto(result);
    }

    @PutMapping(name = "update/{id}")
    public StudentDTO update(@PathVariable Long id,@RequestBody StudentDTO request){
        final Student studentRequest = studentService.mapToEntity(request);
        final Student result = studentService.update(id,studentRequest);
        return studentService.mapToDto(result);
    }

    @DeleteMapping(name = "/student/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return studentService.delete(id);
    }
}

package com.restfulSpringboot.JpaHibernate.controller;

import com.restfulSpringboot.JpaHibernate.dto.StudentCardDTO;
import com.restfulSpringboot.JpaHibernate.model.StudentCard;
import com.restfulSpringboot.JpaHibernate.service.StudentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentCardController {

    @Autowired
    private StudentCardService studentCardService;

    @GetMapping(value = "/card/all")
    public List<StudentCardDTO> findCardAll(){
        return studentCardService.findCardAll()
                .stream()
                .map(studentCard -> studentCardService.mapToDto(studentCard))
                .collect(Collectors.toList()
                );
    }

    @GetMapping(value = "/card/{bookid}")
    public StudentCardDTO findCardById(@PathVariable Long id){
        final StudentCard result = studentCardService.findCardById(id);
        return studentCardService.mapToDto(result);
    }

    @PostMapping(value = "/card/add/{bookid}")
    public StudentCardDTO addCard(@PathVariable Long id,@RequestBody StudentCardDTO request){
        final StudentCard cardRequest = studentCardService.mapToEntity(request);
        final StudentCard result = studentCardService.addCard(id,cardRequest);
        return studentCardService.mapToDto(result);
    }

}

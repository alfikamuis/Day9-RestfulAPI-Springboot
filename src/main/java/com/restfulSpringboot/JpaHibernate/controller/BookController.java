package com.restfulSpringboot.JpaHibernate.controller;

import com.restfulSpringboot.JpaHibernate.dto.BookDTO;
import com.restfulSpringboot.JpaHibernate.model.Book;
import com.restfulSpringboot.JpaHibernate.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(name = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<BookDTO> findBookAll(){
        return bookService.findBookAll()
                .stream()
                .map(book -> bookService.mapToDto(book))
                .collect(Collectors.toList()
                );
    }

    @GetMapping(name = "{bookid}")
    public BookDTO findBookById(@PathVariable Long id){
        final Book result = bookService.findBookById(id);
       return bookService.mapToDto(result);
    }

    @PostMapping(name = "add")
    public BookDTO addBook(@RequestBody BookDTO request){
        final Book studentRequest = bookService.mapToEntity(request);
        final Book result = bookService.addBook(studentRequest);
        return bookService.mapToDto(result);
    }

    @PutMapping(name = "update/{bookid}")
    public BookDTO updateBook(@PathVariable Long id,@RequestBody BookDTO request){
        final Book studentRequest = bookService.mapToEntity(request);
        final Book result = bookService.updateBook(id,studentRequest);
        return bookService.mapToDto(result);
    }

    @DeleteMapping(name = "delete/{bookid}")
    public Boolean deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }
}


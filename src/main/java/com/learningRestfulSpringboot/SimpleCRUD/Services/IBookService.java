package com.learningRestfulSpringboot.SimpleCRUD.Services;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.Book;

import java.util.List;

public interface IBookService {

    Book addBook(Book book);

    void deleteBook(Long id);

    List<Book> findAllBook();
}

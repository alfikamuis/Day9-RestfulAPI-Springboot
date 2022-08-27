package com.restfulSpringboot.JpaHibernate.service;

import com.restfulSpringboot.JpaHibernate.dto.BookDTO;
import com.restfulSpringboot.JpaHibernate.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findBookAll();
    Book findBookById(Long id);
    Book addBook(Book book);
    Book updateBook(Long id,Book book);
    Boolean deleteBook(Long id);

    BookDTO mapToDto(Book book);
    Book mapToEntity(BookDTO bookDTO);
}

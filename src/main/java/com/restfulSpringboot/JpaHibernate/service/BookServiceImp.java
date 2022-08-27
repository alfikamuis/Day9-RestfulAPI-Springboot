package com.restfulSpringboot.JpaHibernate.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restfulSpringboot.JpaHibernate.dto.BookDTO;
import com.restfulSpringboot.JpaHibernate.model.Book;
import com.restfulSpringboot.JpaHibernate.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService{

    @Autowired
    StudentService studentService;

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findBookAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        Optional<Book> result = bookRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    @Override
    public Book addBook(Book book) {
        book.setCreatedAt(LocalDate.now());
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book result = findBookById(id);
        if(result != null){
            result.setBookName(book.getBookName());
            book.setCreatedAt(LocalDate.now());
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public Boolean deleteBook(Long id) {
        final Book result = findBookById(id);
        if (result != null){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    ObjectMapper bookMapper = new ObjectMapper();

    @Override
    public BookDTO mapToDto(Book book) {
        return bookMapper.convertValue(book, BookDTO.class);
    }

    @Override
    public Book mapToEntity(BookDTO bookDTO) {
        return bookMapper.convertValue(bookDTO, Book.class);
    }
}

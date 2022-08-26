package com.learningRestfulSpringboot.SimpleCRUD.Services;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.Book;
import com.learningRestfulSpringboot.SimpleCRUD.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book){
        book.setCreatedAt(LocalDate.now());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllBook(){
       return bookRepository.findAll();
    }

}

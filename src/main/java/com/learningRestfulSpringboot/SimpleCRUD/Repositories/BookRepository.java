package com.learningRestfulSpringboot.SimpleCRUD.Repositories;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}

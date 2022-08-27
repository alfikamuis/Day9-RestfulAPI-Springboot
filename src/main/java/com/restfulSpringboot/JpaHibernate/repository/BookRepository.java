package com.restfulSpringboot.JpaHibernate.repository;

import com.restfulSpringboot.JpaHibernate.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}

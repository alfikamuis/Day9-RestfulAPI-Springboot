package com.restfulSpringboot.JpaHibernate.repository;

import com.restfulSpringboot.JpaHibernate.model.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCardRepository extends JpaRepository<StudentCard,Long> {
}

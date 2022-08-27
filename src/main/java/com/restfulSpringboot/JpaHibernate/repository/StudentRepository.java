package com.restfulSpringboot.JpaHibernate.repository;

import com.restfulSpringboot.JpaHibernate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s WHERE s.email =x")
    Optional<Student> findByEmail(@Param("x") String email);

}

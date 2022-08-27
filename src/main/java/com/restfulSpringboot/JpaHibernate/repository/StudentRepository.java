package com.restfulSpringboot.JpaHibernate.repository;

import com.restfulSpringboot.JpaHibernate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true) //main data protected
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s WHERE s.email =x")
    Optional<Student> findByEmail(@Param("x") String email);

}

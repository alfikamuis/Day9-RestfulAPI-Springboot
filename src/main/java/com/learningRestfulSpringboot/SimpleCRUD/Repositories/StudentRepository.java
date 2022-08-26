package com.learningRestfulSpringboot.SimpleCRUD.Repositories;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findById(Long id);

    @Modifying
    @Query("select s from student s where s.name = :name")
    Optional<Student> findByName(@Param("name")String name);

    @Modifying
    @Query("select s from student s where s.email =?1")
    Optional<Student> findByEmail(String email);
}

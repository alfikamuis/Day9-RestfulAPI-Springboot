package com.learningRestfulSpringboot.SimpleCRUD.Repositories;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCardRepository extends JpaRepository<StudentCard,Long> {

}

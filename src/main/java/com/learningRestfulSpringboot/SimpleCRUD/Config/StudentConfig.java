package com.learningRestfulSpringboot.SimpleCRUD.Config;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.Student;
import com.learningRestfulSpringboot.SimpleCRUD.Repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student alfika = new Student(
                    "Alfika",
                    "alfika@gmail.com",
                    29,
                    LocalDate.now()
            );
             studentRepository.saveAll(List.of(alfika));
        };
    }
}

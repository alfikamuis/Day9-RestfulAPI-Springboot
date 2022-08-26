package com.learningRestfulSpringboot.SimpleCRUD.Services;

import com.learningRestfulSpringboot.SimpleCRUD.Entities.Student;
import com.learningRestfulSpringboot.SimpleCRUD.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IUserService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository =studentRepository;
    }

    //show all student
    public List<Student> getStudent () {
        return studentRepository.findAll();
    }

    //show student by Id
    @Override
    public Optional<Student> getStudentById (Long id){ return studentRepository.findById(id);}

    //show student by name
    @Override
    public Optional<Student> getStudentByName(String name){ return studentRepository.findByName(name);}

    //add if email not duplicated
    public Student addStudent(Student student){
        Optional<Student> checkEmail = studentRepository.findByEmail(student.getEmail());
        if(checkEmail.isPresent()){
            throw new IllegalStateException("email already exist!");
        }

        student.setCreatedAt(LocalDate.now());
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }
}

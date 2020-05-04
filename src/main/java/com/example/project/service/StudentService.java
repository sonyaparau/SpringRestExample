package com.example.project.service;

import com.example.project.model.Student;
import com.example.project.repository.StudentRepository;
import com.example.project.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    Validator validator;

    Student addStudent(Student student) {
        if (validator.validateName(student.getFirstName()) && validator.validateName(student.getLastName()))
            return studentRepository.save(student);
        return null;
    }

    Student deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            studentRepository.delete(student.get());
            return student.get();
        } else {
            return null;
        }
    }
}

package com.example.project.service;

import com.example.project.model.Student;

public interface StudentService {

    Student addStudent(Student student);
    Student deleteStudent(Long id);
}

package com.example.project.service;

import com.example.project.model.Teacher;
import com.example.project.repository.TeacherRepository;
import com.example.project.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    Validator validator;

    Teacher deleteTeacher(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isPresent()) {
            teacherRepository.delete(teacher.get());
            return teacher.get();
        } else {
            return null;
        }
    }

    Teacher addTeacher(Teacher teacher) {
        if (validator.validateName(teacher.getFirstName()) && validator.validateName(teacher.getLastName())) {
            return teacherRepository.save(teacher);
        } else {
            return null;
        }
    }

}

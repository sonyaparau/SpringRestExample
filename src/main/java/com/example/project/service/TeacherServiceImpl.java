package com.example.project.service;

import com.example.project.model.Teacher;
import com.example.project.repository.TeacherRepository;
import com.example.project.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private Validator validator;


    public Teacher deleteTeacher(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isPresent()) {
            teacherRepository.delete(teacher.get());
            return teacher.get();
        } else {
            return null;
        }
    }

    public Teacher addTeacher(Teacher teacher) {
        if (validator.validateName(teacher.getFirstName()) && validator.validateName(teacher.getLastName())) {
            return teacherRepository.save(teacher);
        } else {
            return null;
        }
    }

}

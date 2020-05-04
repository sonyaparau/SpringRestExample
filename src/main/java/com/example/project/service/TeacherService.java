package com.example.project.service;

import com.example.project.model.Teacher;

public interface TeacherService {
    Teacher deleteTeacher(Long id);
    Teacher addTeacher(Teacher teacher);
}

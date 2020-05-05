package com.example.project.service;

import com.example.project.model.Course;
import com.example.project.model.Student;
import com.example.project.model.Teacher;
import com.example.project.repository.CourseRepository;
import com.example.project.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    Validator validator;

    public Course addCourse(Course course) {
        if (validator.validateCredits(course.getCredits()))
            return courseRepository.save(course);
        return null;
    }

    public Course addCourseWTeacherAStudent(Course course, Student student, Teacher teacher) {
        Course savedCourse = addCourse(course);
        if (Objects.nonNull(savedCourse)) {
            if (Objects.nonNull(student)) {
                student.addCourse(savedCourse);
            }
            if (Objects.nonNull(teacher)) {
                teacher.addCourse(savedCourse);
            }
            return savedCourse;
        } else {
            return null;
        }
    }
}

package com.example.project.service;

import com.example.project.model.Course;
import com.example.project.repository.CourseRepository;
import com.example.project.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    Validator validator;

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        if (validator.validateCredits(course.getCredits()))
            return courseRepository.save(course);
        return null;
    }
}

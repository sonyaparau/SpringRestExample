package com.example.project.service;

import com.example.project.model.Course;
import com.example.project.model.Student;
import com.example.project.model.Teacher;
import com.example.project.repository.StudentRepository;
import com.example.project.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    @Autowired
    private CourseService courseService;
    @Autowired
//    private StudentRepository studentRepository;
//    @Autowired
//    private TeacherRepository teacherRepository;

    @Test
    private void testAddCourse() {
        Course course = new Course();
        course.setCredits(3);
        course.setName("Baze de date");
        Course addedCourse = courseService.addCourse(course);
        assertEquals("Baze de date", addedCourse.getName());
    }

}
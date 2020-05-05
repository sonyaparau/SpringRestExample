package com.example.project.service;

import com.example.project.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void testAddCourse() {
        Course course = new Course();
        course.setId(200L);
        course.setCredits(3);
        course.setName("Baze de date");
        course.setMaxEnrollment(70);
        Course addedCourse = courseService.addCourse(course);
        assertEquals("Baze de date", addedCourse.getName());
    }

}
package com.example.project.service;


import com.example.project.model.Course;
import com.example.project.model.Student;
import com.example.project.model.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BigBangIntegrationTest {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;

    //P -> A -> B -> C (big bang integration
    @Test
    public void addCourseWithStudentAndTeacher() {
        Student student = createStudent();
        Teacher teacher = createTeacher();
        Course course = createCourse();

        Course addedCourse = courseService.addCourseWTeacherAStudent(course, student, teacher);

        assertNotNull(addedCourse);
        assertEquals(1, addedCourse.getTeachers().size());
        assertEquals(1, addedCourse.getEnrolledStudents().size());
        assertEquals(1, student.getAttendedCourses().size());
        assertEquals(1, teacher.getEnrolledCourses().size());
    }

    private Student createStudent() {
        Student student = new Student();
        student.setFirstName("Student");
        student.setLastName("Student");
        student.setTotalCredits(30);
        return studentService.addStudent(student);
    }

    private Teacher createTeacher() {
        Teacher teacher = new Teacher();
        teacher.setLastName("Teacher");
        teacher.setFirstName("Teacher");
        return teacherService.addTeacher(teacher);
    }

    private Course createCourse() {
        Course course = new Course();
        course.setMaxEnrollment(70);
        course.setName("Test course");
        course.setId(1000L);
        course.setCredits(7);
        return course;

    }
}

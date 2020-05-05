package com.example.project.service;

import com.example.project.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    StudentService studentService;

    @Test
    public void testDeleteStudentInvalid() {
        Student student = studentService.deleteStudent(900L);
        assertNull(student);
    }

    @Test
    public void addStudentValid() {
        Student student = new Student();
        student.setId(100L);
        student.setFirstName("Popescu");
        student.setLastName("Ion");
        Student studentAdded = studentService.addStudent(student);
        assertEquals("Popescu", studentAdded.getFirstName());
    }

    @Test
    public void addStudentInvalid() {
        Student student = new Student();
        student.setId(200L);
        student.setFirstName("popescu");
        student.setLastName("ion");
        Student studentAdded = studentService.addStudent(student);
        assertNull(studentAdded);
    }

}
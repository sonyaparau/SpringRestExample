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
    StudentServiceImpl studentServiceImpl;

    @Test
    public void testDeleteStudentValid() {
        Student student = studentServiceImpl.deleteStudent(2L);
//        assertEquals("Catalin", student.getFirstName());
    }

    @Test
    public void testDeleteStudentInvalid() {
        Student student = studentServiceImpl.deleteStudent(200L);
        assertNull(student);
    }

    @Test
    public void addStudentValid() {
        Student student = new Student();
        student.setId(100L);
        student.setFirstName("Popescu");
        student.setLastName("Ion");
        Student studentAdded = studentServiceImpl.addStudent(student);
        assertEquals("Popescu", studentAdded.getFirstName());
    }

    @Test
    public void addStudentInavlid() {
        Student student = new Student();
        student.setId(100L);
        student.setFirstName("popescu");
        student.setLastName("ion");
        Student studentAdded = studentServiceImpl.addStudent(student);
        assertNull(studentAdded);
    }

}
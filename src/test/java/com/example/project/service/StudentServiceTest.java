package com.example.project.service;

import com.example.project.model.Student;
import com.example.project.repository.StudentRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    private void testDeleteStudentValid() {
        Student student = studentService.deleteStudent(2L);
        assertEquals(2L, student.getId());
        assertEquals("Catalin", student.getFirstName());
    }

    @Test
    private void testDeleteStudentInvalid() {
        Student student = studentService.deleteStudent(200L);
        assertNull(student);
    }

    @Test
    private void addStudentValid() {
        Student student = new Student();
        student.setId(100L);
        student.setFirstName("Popescu");
        student.setLastName("Ion");
        Student studentAdded = studentService.addStudent(student);
        assertEquals("Popescu", studentAdded.getFirstName());
    }

    @Test
    private void addStudentInavlid() {
        Student student = new Student();
        student.setId(100L);
        student.setFirstName("popescu");
        student.setLastName("ion");
        Student studentAdded = studentService.addStudent(student);
        assertNull(student);
    }


}
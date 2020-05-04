package com.example.project.service;

import com.example.project.model.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TeacherServiceTest {

    @Autowired
    TeacherService teacherService;

    @Test
    private void testDeleteTeacherValid() {
        Teacher teacher = teacherService.deleteTeacher(2L);
        assertEquals(2L, teacher.getId());
        assertEquals("Catalin", teacher.getFirstName());
    }

    @Test
    private void testDeleteTeacherInvalid() {
        Teacher teacher = teacherService.deleteTeacher(200L);
        assertNull(teacher);
    }


    @Test
    private void addTeacherValid() {
        Teacher teacher = new Teacher();
        teacher.setId(100L);
        teacher.setFirstName("Popescu");
        teacher.setLastName("Ion");
        Teacher teacherAdded = teacherService.addTeacher(teacher);
        assertEquals("Popescu", teacherAdded.getFirstName());
    }

    @Test
    private void addTeacherInavlid() {
        Teacher teacher = new Teacher();
        teacher.setId(100L);
        teacher.setFirstName("popescu");
        teacher.setLastName("ion");
        Teacher teacherAdded = teacherService.addTeacher(teacher);
        assertNull(teacher);
    }

}
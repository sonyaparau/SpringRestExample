package com.example.project.service;

import com.example.project.model.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TeacherServiceImplTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void testDeleteTeacherInvalid() {
        Teacher teacher = teacherService.deleteTeacher(300L);
        assertNull(teacher);
    }

    @Test
    public void addTeacherValid() {
        Teacher teacher = new Teacher();
        teacher.setId(100L);
        teacher.setFirstName("Petrescu");
        teacher.setLastName("Adrian");
        Teacher teacherAdded = teacherService.addTeacher(teacher);
        assertEquals("Petrescu", teacherAdded.getFirstName());
    }

    @Test
    public void addTeacherInvalid() {
        Teacher teacher = new Teacher();
        teacher.setId(200L);
        teacher.setFirstName("petrescu");
        teacher.setLastName("adrian");
        Teacher teacherAdded = teacherService.addTeacher(teacher);
        assertNull(teacherAdded);
    }

}
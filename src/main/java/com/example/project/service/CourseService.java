package com.example.project.service;

import com.example.project.model.Course;
import com.example.project.model.Student;
import com.example.project.model.Teacher;

public interface CourseService {

    Course addCourse(Course course);
    Course addCourseWTeacherAStudent(Course course, Student student, Teacher teacher);
}

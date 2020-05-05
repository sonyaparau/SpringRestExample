package com.example.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "course")
@Entity
public class Course {

    @Id
    @Column(name = "idcourse")
//    @GeneratedValue(strategy = GenerationType.)
    private Long id;

    @Column(name = "namecourse")
    private String name;

    @Column(name = "maxenrollment")
    private Integer maxEnrollment;

    @Column(name = "credits")
    private Integer credits;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "attendedCourses")
    @JsonIgnore
    private Set<Student> enrolledStudents = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "enrolledCourses")
    @JsonIgnore
    private Set<Teacher> teachers = new HashSet<>();

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(Integer maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}

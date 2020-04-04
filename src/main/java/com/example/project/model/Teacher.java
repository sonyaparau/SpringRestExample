package com.example.project.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "teacher")
@Entity
public class Teacher {

    @Id
    @Column(name = "idteacher")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "course_teacher",
            joinColumns = @JoinColumn(name = "idteacher"),
            inverseJoinColumns = @JoinColumn(name = "idcourseteacher")
    )
    private Set<Course> enrolledCourses = new HashSet<>();

    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(Set<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void addCourse(Course course) {
        enrolledCourses.add(course);
        course.getTeachers().add(this);
    }

    public void removeCourse(Course course) {
        enrolledCourses.remove(course);
        course.getTeachers().remove(this);
    }
}

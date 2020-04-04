package com.example.project.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "student")
@Entity
public class Student{

    @Id
    @Column(name = "idstudent")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name= "totalcredits")
    private Integer totalCredits;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "idstudent"),
            inverseJoinColumns = @JoinColumn(name = "idcourse")
    )
    private Set<Course> attendedCourses = new HashSet<>();

    public Student() {
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

    public Integer getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(Integer totalCredits) {
        this.totalCredits = totalCredits;
    }

    public Set<Course> getAttendedCourses() {
        return attendedCourses;
    }

    public void setAttendedCourses(Set<Course> attendedCourses) {
        this.attendedCourses = attendedCourses;
    }

    public void addCourse(Course course) {
        attendedCourses.add(course);
        course.getEnrolledStudents().add(this);
    }

    public void removeCourse(Course course) {
        attendedCourses.remove(course);
        course.getEnrolledStudents().remove(this);
    }
}
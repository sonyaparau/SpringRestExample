package com.example.project.controller;

import com.example.project.model.Course;
import com.example.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * @param id of the course that must be
     *           searched in the database
     */
    @GetMapping("/{id}")
    public Course getById(@PathVariable("id") Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent())
            return course.get();
        return null;
    }

    /**
     * @return list of all courses
     */
    @GetMapping
    public List<Course> getAll() {
        return courseRepository.findAll();
    }


    /**
     * Deletes a course from the database after
     * its id, if the id exists in the database.
     *
     * @param id of the course that must be deleted
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        courseRepository.deleteById(id);
    }


    /**
     * @param course to be added
     * @return added course or null if a problem occurred
     */
    @PostMapping
    public Course add(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    /**
     * If the course with the given Id exists in the
     * database, then its attributes will be updated.
     * Otherwise, a new course with the given id will
     * be added.
     *
     * @param course to be updated
     */
    @PutMapping("/{id}")
    public Course update(@PathVariable("id") Long id, @RequestBody Course course) {
        if (courseRepository.findById(id).isPresent()) {
            return courseRepository.save(course);
        }
        return null;
    }
}

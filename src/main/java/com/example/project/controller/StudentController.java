package com.example.project.controller;

import com.example.project.model.Student;
import com.example.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * @param id of the student that must be
     *           searched in the database
     */
    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent())
            return student.get();
        return null;
    }

    /**
     * @return list of all students
     */
    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }


    /**
     * Deletes a student from the database after
     * its id, if the id exists in the database.
     *
     * @param id of the student that must be deleted
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
    }


    /**
     * @param student to be added
     * @return added student or null if a problem occurred
     */
    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    /**
     * If the student with the given Id exists in the
     * database, then its attributes will be updated.
     * Otherwise, a new student with the given id will
     * be added.
     *
     * @param student to be updated
     */
    @PutMapping("/{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.save(student);
        }
        return null;
    }
}
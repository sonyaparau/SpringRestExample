package com.example.project.controller;

import com.example.project.model.Teacher;
import com.example.project.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * @param id of the teacher that must be
     *           searched in the database
     */
    @GetMapping("/{id}")
    public Teacher getById(@PathVariable("id") Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent())
            return teacher.get();
        return null;
    }

    /**
     * @return list of all teachers
     */
    @GetMapping
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }


    /**
     * Deletes a teacher from the database after
     * its id, if the id exists in the database.
     *
     * @param id of the teacher that must be deleted
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        teacherRepository.deleteById(id);
    }


    /**
     * @param teacher to be added
     * @return added teacher or null if a problem occurred
     */
    @PostMapping
    public Teacher add(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    /**
     * If the teacher with the given Id exists in the
     * database, then its attributes will be updated.
     * Otherwise, a new teacher with the given id will
     * be added.
     *
     * @param teacher to be updated
     */
    @PutMapping("/{id}")
    public Teacher update(@PathVariable("id") Long id, @RequestBody Teacher teacher) {
        if (teacherRepository.findById(id).isPresent()) {
            return teacherRepository.save(teacher);
        }
        return null;
    }
}

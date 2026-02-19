package com.example.in_memory_mock.student.controller;

import com.example.in_memory_mock.student.entity.Student;
import com.example.in_memory_mock.student.service.StudentService;
import com.example.in_memory_mock.student_teacher.service.StudentTeacherService;
import com.example.in_memory_mock.teacher.entity.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentTeacherService studentTeacherService;

    // constructor injection for studentService & studentTeacherService
    public StudentController(
        StudentService studentService,
        StudentTeacherService studentTeacherService
    ) {
        this.studentService = studentService;
        this.studentTeacherService = studentTeacherService;
    }

    // TODO: api to create student
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestParam Student newStudent) {
        return studentService.create(newStudent);
    }

    // TODO: api to get student,
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable UUID id) {
        return studentService.get(id);
    }

    // TODO: api to update student
    @PutMapping("/{id}")
    public Student updateStudent(
        @PathVariable UUID id,
        @RequestParam Student newStudentData
    ) {
        return studentService.update(id, newStudentData);
    }

    // TODO: api to delete student
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable UUID id) {
        studentService.delete(id);
    }

    // TODO: api to get teachers by student id
    @GetMapping("/getRelatedTeachers/{id}")
    public List<Teacher> getTeachersByStudentId(@PathVariable UUID id) {
        return studentTeacherService.getTeachersByStudentId(id);
    }
}

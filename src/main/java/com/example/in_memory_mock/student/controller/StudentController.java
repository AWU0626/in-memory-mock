package com.example.in_memory_mock.student.controller;

import com.example.in_memory_mock.student.dto.StudentDTO;
import com.example.in_memory_mock.student.service.StudentService;
import com.example.in_memory_mock.student_teacher.service.StudentTeacherService;
import com.example.in_memory_mock.teacher.dto.TeacherDTO;
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
    public StudentDTO createStudent(@RequestBody StudentDTO newStudentDTO) {
        return studentService.create(newStudentDTO);
    }

    // TODO: api to get student,
    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable UUID id) {
        return studentService.get(id);
    }

    // TODO: api to update student
    @PutMapping("/{id}")
    public StudentDTO updateStudent(
        @PathVariable UUID id,
        @RequestBody StudentDTO newStudentDTOData
    ) {
        return studentService.update(id, newStudentDTOData);
    }

    // TODO: api to delete student
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable UUID id) {
        studentService.delete(id);
    }

    // TODO: api to get teachers by student id
    @GetMapping("/{id}/getRelatedTeachers")
    public List<TeacherDTO> getTeachersByStudentId(@PathVariable UUID id) {
        return studentTeacherService.getTeachersByStudentId(id);
    }
}

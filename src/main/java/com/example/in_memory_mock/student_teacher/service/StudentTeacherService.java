package com.example.in_memory_mock.student_teacher.service;

import com.example.in_memory_mock.student_teacher.entity.StudentTeacher;
import com.example.in_memory_mock.student_teacher.repository.StudentTeacherRepository;
import com.example.in_memory_mock.teacher.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentTeacherService {
    private final StudentTeacherRepository studentTeacherRepository;

    // student teacher repository constructor injection
    public StudentTeacherService(StudentTeacherRepository studentTeacherRepository) {
        this.studentTeacherRepository = studentTeacherRepository;
    }

    // TODO: get list of teachers by student id
    public List<Teacher> getTeachersByStudentId(UUID studentId) {
        List<StudentTeacher> studentTeachers = studentTeacherRepository.findByStudentId(studentId);

        return studentTeachers
                    .stream()
                    .map(StudentTeacher::getTeacher) // map to teacher
                    .toList(); // convert the stream of teacher to list of teachers
    }
}

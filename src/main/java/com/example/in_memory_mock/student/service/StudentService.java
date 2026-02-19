package com.example.in_memory_mock.student.service;

import com.example.in_memory_mock.student.dto.StudentDTO;
import com.example.in_memory_mock.student.dto.StudentMapper;
import com.example.in_memory_mock.student.entity.Student;
import com.example.in_memory_mock.student.repository.StudentRepository;
import com.example.in_memory_mock.teacher.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    // student repository constructor injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // TODO: create student
    public StudentDTO create(StudentDTO studentDTO) {
        Student student = StudentMapper.createNewStudentEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);

        return StudentMapper.toStudentDTO(savedStudent);
    }

    // TODO: get student by id, if no result, returns null
    public StudentDTO get(UUID id) {
        Student student = studentRepository
                            .findById(id)
                            .orElseThrow(() -> new RuntimeException("Student not found"));

        return StudentMapper.toStudentDTO(student);
    }

    // TODO: update student
    public StudentDTO update(UUID id, StudentDTO newStudentDTOData) {
        Student student = studentRepository
                            .findById(id)
                            .orElseThrow(() -> new RuntimeException("Student not found"));

        String newFirstName = newStudentDTOData.getFirstName();
        String newLastName = newStudentDTOData.getLastName();
        Integer newAge = newStudentDTOData.getAge();

        if (newFirstName != null)  student.setFirstName(newFirstName);
        if (newLastName != null)  student.setLastName(newLastName);
        if (newAge != null)  student.setAge(newAge);

        Student updatedStudent = studentRepository.save(student);
        return StudentMapper.toStudentDTO(updatedStudent);
    }

    // TODO: delete student
    public void delete(UUID id) {
        studentRepository.deleteById(id);
    }
}

package com.example.in_memory_mock.student.service;

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
    public Student create(Student student) {
        // @Repository -> JpaRepository --> ListCrudRepository -> crudRepository's save function
        return studentRepository.save(student);
    }

    // TODO: get student by id, if no result, returns null
    public Student get(UUID id) {
        return studentRepository
                .findById(id)
                .orElse(null);
    }

    // TODO: update student
    public Student update(UUID id, Student newStudentData) {
        Student student = get(id);

        String newFirstName = newStudentData.getFirstName();
        String newLastName = newStudentData.getLastName();
        Integer newAge = newStudentData.getAge();

        if (newFirstName != null)  student.setFirstName(newFirstName);
        if (newLastName != null)  student.setLastName(newLastName);
        if (newAge != null)  student.setAge(newAge);

        // return student with updated data
        return studentRepository.save(student);
    }

    // TODO: delete student
    public void delete(UUID id) {
        studentRepository.deleteById(id);
    }
}

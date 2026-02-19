package com.example.in_memory_mock.student.dto;

import com.example.in_memory_mock.student.entity.Student;

public class StudentMapper {
    public static StudentDTO toStudentDTO(Student student) {
        if (student == null) return null;

        return new StudentDTO(
            student.getId(),
            student.getFirstName(),
            student.getLastName(),
            student.getAge()
        );
    }

    public static void toStudentEntity(
        StudentDTO studentDTO,
        Student student
    ) {
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAge(studentDTO.getAge());
    }

    public static Student createNewStudentEntity(StudentDTO studentDTO) {
        Student student = new Student();
        toStudentEntity(studentDTO, student);
        return student;
    }
}

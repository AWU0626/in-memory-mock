package com.example.in_memory_mock.teacher.dto;

import com.example.in_memory_mock.teacher.entity.Teacher;

public class TeacherMapper {
    public static TeacherDTO toTeacherDTO(Teacher teacher) {
        if (teacher == null) return null;

        return new TeacherDTO(
            teacher.getId(),
            teacher.getFirstName(),
            teacher.getLastName(),
            teacher.getAge()
        );
    }

    public static void toTeacherEntity(
        TeacherDTO teacherDTO,
        Teacher teacher
    ) {
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setAge(teacherDTO.getAge());
    }

    public static Teacher createNewTeacherEntity(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        toTeacherEntity(teacherDTO, teacher);
        return teacher;
    }
}

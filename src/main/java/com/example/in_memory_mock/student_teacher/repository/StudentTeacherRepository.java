package com.example.in_memory_mock.student_teacher.repository;

import com.example.in_memory_mock.student_teacher.entity.StudentTeacher;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentTeacherRepository extends JpaRepository<StudentTeacher, Long> {
    @Query("""
        select st
        from StudentTeacher st
        where st.student.id = :studentId
    """)
    List<StudentTeacher> findByStudentId(@Param("studentId") UUID studentId);
}

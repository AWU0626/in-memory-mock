package com.example.in_memory_mock.repository;

import com.example.in_memory_mock.entity.Student;
import org.springframework.boot.data.autoconfigure.metrics.DataMetricsProperties;

public class StudentRepository extends DataMetricsProperties.Repository<Student> {
}

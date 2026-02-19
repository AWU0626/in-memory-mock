package com.example.in_memory_mock.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "STUDENTS")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // UUID auto generate
    @Column(name = "id")
    private UUID id;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
}

package com.example.school_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school_management.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

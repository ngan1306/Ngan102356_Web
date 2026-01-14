package com.example.lab3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab3.entity.Student;

public interface StudentRepository
        extends JpaRepository<Student, Long> {
                // Tìm sinh viên theo tên (không phân biệt hoa thường)
                List<Student> findByNameContainingIgnoreCase(String name);
}

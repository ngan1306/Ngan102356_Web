package com.example.lab3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lab3.entity.Student;
import com.example.lab3.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Lấy tất cả sinh viên
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Lấy sinh viên theo ID
    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Tìm sinh viên theo tên
    public List<Student> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    // Lưu sinh viên
    public void saveStudent(Student student) {
        repository.save(student);
    }
}

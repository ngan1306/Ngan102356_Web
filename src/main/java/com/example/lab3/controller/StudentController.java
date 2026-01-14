package com.example.lab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lab3.entity.Student;
import com.example.lab3.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }

    @GetMapping("/students/{id}")
    public String studentDetail(@PathVariable Long id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "student-detail";
    }

    @GetMapping("/students/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Student> list = service.searchByName(keyword);
        model.addAttribute("students", list);
        return "students";
    }
}

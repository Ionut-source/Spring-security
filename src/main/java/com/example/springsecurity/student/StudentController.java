package com.example.springsecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Ionut Cumpanasoiu"),
            new Student(2, "Maria Ene"),
            new Student(3, "Bogdan Popescu")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.
                stream().
                filter(student -> studentId.equals(student.getStudentId())).
                findFirst().
                orElseThrow(() -> new IllegalStateException("Student with id: " + studentId + " does not exists"));
    }
}

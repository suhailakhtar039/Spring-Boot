package com.suhail.demo.rest;

import com.suhail.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("suhail", "akhtar"));
        students.add(new Student("John", "Wick"));
        students.add(new Student("abc", "xyz"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentWithId(@PathVariable("studentId") int id) {

        if (id < 0 || id >= students.size()){
            throw new StudentsNotFoundException("Student id not found - " + id);
        }

            return students.get(id);
    }


}

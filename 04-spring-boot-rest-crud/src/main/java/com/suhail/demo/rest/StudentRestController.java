package com.suhail.demo.rest;

import com.suhail.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("suhail","akhtar"));
        students.add(new Student("John","Wick"));
        students.add(new Student("abc","xyz"));
        return students;
    }
}

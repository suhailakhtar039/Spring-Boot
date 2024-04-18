package com.suhail.cruddemo.dao;

import com.suhail.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

}

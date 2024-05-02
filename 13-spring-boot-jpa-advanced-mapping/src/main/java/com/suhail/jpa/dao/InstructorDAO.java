package com.suhail.jpa.dao;

import com.suhail.jpa.entity.Instructor;

public interface InstructorDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

}

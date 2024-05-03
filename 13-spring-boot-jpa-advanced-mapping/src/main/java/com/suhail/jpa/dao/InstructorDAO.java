package com.suhail.jpa.dao;

import com.suhail.jpa.entity.Course;
import com.suhail.jpa.entity.Instructor;

import java.util.List;

public interface InstructorDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    List<Course> findCoursesByInstructorId(int id);

}

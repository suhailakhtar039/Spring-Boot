package com.suhail.jpa.dao;

import com.suhail.jpa.entity.Course;
import com.suhail.jpa.entity.Instructor;
import com.suhail.jpa.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);
}

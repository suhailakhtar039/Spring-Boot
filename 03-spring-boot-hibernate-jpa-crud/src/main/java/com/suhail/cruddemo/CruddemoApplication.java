package com.suhail.cruddemo;

import com.suhail.cruddemo.dao.StudentDAO;
import com.suhail.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
            createStudent(studentDAO);
            createStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all row");
        int row = studentDAO.deleteAll();
        System.out.println("Deleted rows are: " + row);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int id = 3;
        System.out.println("Deleting student id: " + id);
        studentDAO.delete(id);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student student = studentDAO.findById(studentId);

        System.out.println("Updating student.....");
        student.setFirstName("ABC");
        studentDAO.update(student);

        System.out.println("Updated student....");
        System.out.println(student);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("abc");
        System.out.println(students);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student temp : students) {
            System.out.println(temp);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object.....");
        Student tempStudent = new Student("john", "nick", "john.nick@abc.com");

        System.out.println("Saving....");
        studentDAO.save(tempStudent);

        System.out.println("new object created, see the id: " + tempStudent.getId());

        // retrieving student on the basis of ID
        System.out.println("Retrieving Student on the basis of ID: " + tempStudent.getId());

        Student myStudent = studentDAO.findById(tempStudent.getId());
        System.out.println("Found the student");
        System.out.println(myStudent);
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("creating new object.....");
        Student student = new Student("4suhail3", "4akhtar3", "4abc3@gmail.com");
        System.out.println("saving the object..........");
        studentDAO.save(student);
        System.out.println("new object created, see the id: " + student.getId());
    }
}

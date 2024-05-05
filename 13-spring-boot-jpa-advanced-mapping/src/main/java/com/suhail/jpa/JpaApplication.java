package com.suhail.jpa;

import com.suhail.jpa.dao.AppDAO;
import com.suhail.jpa.dao.InstructorDetailService;
import com.suhail.jpa.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			// createCourseAndStudents(appDAO);
			// findCourseAndStudents(appDAO);
			findStudentsAndCourses(appDAO);
		};

	}

	private void findStudentsAndCourses(AppDAO appDAO) {
		int id = 2;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);
		System.out.println("Student = " + student);
		System.out.println("Courses = " + student.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 11;
		Course course = appDAO.findCourseAndStudentByCourseId(id);

		System.out.println("Loaded course: " + course);
		System.out.println("Students: " + course.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course1 = new Course("SQL beginner to advanced");
		Course course2 = new Course("Check the new coursed");

		Student student1 = new Student("Suhail", "Akhtar", "suhail.akhtar@test.com");
		Student student2 = new Student("abc", "xyz", "abc.xyz@test.com");
		Student student3 = new Student("mary", "last", "mary.last@test.com");
		Student student4 = new Student("susan", "admin", "susan.admin@test.com");

		course1.addStudent(student1);
		course1.addStudent(student2);

		course2.addStudent(student3);
		course2.addStudent(student4);

		System.out.println("Saving the course: " + course1);
		System.out.println("Associated students: " + course1.getStudents());

		System.out.println("Saving new course: " + course2);
		System.out.println("Associated students for course2: " + course2.getStudents());

		appDAO.save(course1);
		appDAO.save(course2);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		appDAO.deleteCourseById(id);
		System.out.println("Done!!");
	}

	private void retriveCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(id);
		System.out.println(course);
		System.out.println(course.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("How to play Mario");
		course.addReview(new Review("great man"));
		course.addReview(new Review("suhail akhtar"));
		course.addReview(new Review("abcd"));
		course.addReview(new Review("what's going on?"));

		System.out.println("saving the course");
		System.out.println(course);
		System.out.println(course.getReviews());

		appDAO.save(course);
		System.out.println("Done!!!");
	}

	private void deleteCourseById(AppDAO appDAO) {
		int id = 10;
		appDAO.deleteCourseById(id);
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Finding course with id: " + id);
		Course course = appDAO.findCourseById(id);
		course.setTitle("Completing course!!!");
		appDAO.update(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("finding object having id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		instructor.setLastName("update");
		appDAO.update(instructor);

		System.out.println("Done!!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding courses with id " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor = " + instructor);
		System.out.println("Associated courses " + instructor.getCourses());

		System.out.println("Done!!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("instructor = " + instructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);

		System.out.println("the associated courses: " + instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("finding instructor having id: " + id);
		Instructor instructorById = appDAO.findInstructorById(id);
		System.out.println("instructor = " + instructorById);
		System.out.println("courses: " + instructorById.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("suhail", "akhtar", "suhail@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.sample-check.com", "helping other");

		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("Air Guitar - ultimate guide");
		Course course2 = new Course("From suhail");
		instructor.add(course1);
		instructor.add(course2);
		System.out.println("Saving courses");
		System.out.println("The courses: " + instructor.getCourses());
		appDAO.save(instructor);
	}

	private void deleteInstructorDetail(InstructorDetailService instructorDetailService) {
		System.out.println("Deleting starts");
		int id = 2;
		instructorDetailService.deleteInstructorDetailById(id);
		System.out.println("Deleted!");
	}

	private void findInstructorDetail(InstructorDetailService instructorDetailService) {
		int id = 2;
		InstructorDetail instructorDetail = instructorDetailService.findById(id);
		System.out.println("instructorDetail = " + instructorDetail);
		System.out.println("Instructur = " + instructorDetail.getInstructor());
		System.out.println("!Done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteInstructorById(id);
		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorById(3);
		System.out.println(instructor);
		System.out.println("associated instructor detail " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("sample", "check", "sample@check.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.sample-check.com", "helping other");

		instructor.setInstructorDetail(instructorDetail);
		System.out.println("saving instructor " + instructor);
		appDAO.save(instructor);
	}

}

package com.suhail.jpa;

import com.suhail.jpa.dao.InstructorDAO;
import com.suhail.jpa.dao.InstructorDetailService;
import com.suhail.jpa.entity.Course;
import com.suhail.jpa.entity.Instructor;
import com.suhail.jpa.entity.InstructorDetail;
import com.suhail.jpa.entity.Review;
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
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO){
		return runner -> {
			// createCourseAndReviews(instructorDAO);
			retriveCourseAndReviews(instructorDAO);

		};
	}

	private void retriveCourseAndReviews(InstructorDAO instructorDAO) {
		int id = 10;
		Course course = instructorDAO.findCourseAndReviewsByCourseId(id);
		System.out.println(course);
		System.out.println(course.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(InstructorDAO instructorDAO) {
		Course course = new Course("How to play Mario");
		course.addReview(new Review("great man"));
		course.addReview(new Review("suhail akhtar"));
		course.addReview(new Review("abcd"));
		course.addReview(new Review("what's going on?"));

		System.out.println("saving the course");
		System.out.println(course);
		System.out.println(course.getReviews());

		instructorDAO.save(course);
		System.out.println("Done!!!");
	}

	private void deleteCourseById(InstructorDAO instructorDAO) {
		int id = 10;
		instructorDAO.deleteCourseById(id);
	}

	private void updateCourse(InstructorDAO instructorDAO) {
		int id = 10;
		System.out.println("Finding course with id: " + id);
		Course course = instructorDAO.findCourseById(id);
		course.setTitle("Completing course!!!");
		instructorDAO.update(course);
	}

	private void updateInstructor(InstructorDAO instructorDAO) {
		int id = 1;
		System.out.println("finding object having id: " + id);
		Instructor instructor = instructorDAO.findInstructorById(id);

		instructor.setLastName("update");
		instructorDAO.update(instructor);

		System.out.println("Done!!");
	}

	private void findInstructorWithCoursesJoinFetch(InstructorDAO instructorDAO) {
		int id = 1;
		System.out.println("Finding courses with id " + id);
		Instructor instructor = instructorDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor = " + instructor);
		System.out.println("Associated courses " + instructor.getCourses());

		System.out.println("Done!!");
	}

	private void findCoursesForInstructor(InstructorDAO instructorDAO) {
		int id = 1;

		Instructor instructor = instructorDAO.findInstructorById(id);
		System.out.println("instructor = " + instructor);

		List<Course> courses = instructorDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);

		System.out.println("the associated courses: " + instructor.getCourses());
	}

	private void findInstructorWithCourses(InstructorDAO instructorDAO) {
		int id = 1;
		System.out.println("finding instructor having id: " + id);
		Instructor instructorById = instructorDAO.findInstructorById(id);
		System.out.println("instructor = " + instructorById);
		System.out.println("courses: " + instructorById.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(InstructorDAO instructorDAO) {
		Instructor instructor = new Instructor("suhail", "akhtar", "suhail@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.sample-check.com", "helping other");

		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("Air Guitar - ultimate guide");
		Course course2 = new Course("From suhail");
		instructor.add(course1);
		instructor.add(course2);
		System.out.println("Saving courses");
		System.out.println("The courses: " + instructor.getCourses());
		instructorDAO.save(instructor);
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

	private void deleteInstructor(InstructorDAO instructorDAO) {
		int id = 1;
		instructorDAO.deleteInstructorById(id);
		System.out.println("Done");
	}

	private void findInstructor(InstructorDAO instructorDAO) {
		Instructor instructor = instructorDAO.findInstructorById(3);
		System.out.println(instructor);
		System.out.println("associated instructor detail " + instructor.getInstructorDetail());
	}

	private void createInstructor(InstructorDAO instructorDAO) {
		Instructor instructor = new Instructor("sample", "check", "sample@check.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.sample-check.com", "helping other");

		instructor.setInstructorDetail(instructorDetail);
		System.out.println("saving instructor " + instructor);
		instructorDAO.save(instructor);
	}

}

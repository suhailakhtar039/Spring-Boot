package com.suhail.jpa;

import com.suhail.jpa.dao.AppDAO;
import com.suhail.jpa.dao.InstructorDetailService;
import com.suhail.jpa.entity.Instructor;
import com.suhail.jpa.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDetailService instructorDetailService){
		return runner -> {
			// createInstructor(appDAO);
			//findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(instructorDetailService);
			deleteInstructorDetail(instructorDetailService);
		};
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
		appDAO.deleteInstructorById(3);
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

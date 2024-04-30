package com.suhail.jpa;

import com.suhail.jpa.dao.AppDAO;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Suhail", "Akhtar", "suhail@abc.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.abc.com", "sports");

		instructor.setInstructorDetail(instructorDetail);
		System.out.println("saving instructor " + instructor);
		appDAO.save(instructor);
	}

}

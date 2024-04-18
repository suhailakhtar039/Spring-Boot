package com.suhail.cruddemo;

import com.suhail.cruddemo.dao.StudentDAO;
import com.suhail.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			createStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO){
		System.out.println("creating new object.....");
		Student student = new Student("suhail-ex","akhtar-ex","abc@gmail.com");
		System.out.println("saving the object..........");
		studentDAO.save(student);
		System.out.println("new object created, see the id: " + student.getId());
	}
}

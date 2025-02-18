package com.codefrombasics.hibernatedemo;

import com.codefrombasics.hibernatedemo.dao.AppDao;
import com.codefrombasics.hibernatedemo.entity.Instructor;
import com.codefrombasics.hibernatedemo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernatedemoApplication {

	public static void main(String[] args) {
		System.out.println("Inside Main Function of Spring Boot App");
		SpringApplication.run(HibernatedemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner->{
			createInstructor(appDao);
		};
	}

	private void createInstructor(AppDao appDao){

		Instructor instructor=new Instructor("Hanish","Menon","Hanish@gmail.com");

		InstructorDetails instructorDetails=
				new InstructorDetails("www.youtube.com/mychannel","coding");

		instructor.setInstructorDetails(instructorDetails);

		appDao.save(instructor);
		System.out.println("Added Instructor Successfully!!!!");
	}
}

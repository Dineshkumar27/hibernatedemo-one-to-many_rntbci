package com.codefrombasics.hibernatedemo;

import com.codefrombasics.hibernatedemo.entity.Instructor;
import com.codefrombasics.hibernatedemo.entity.InstructorDetails;
import com.codefrombasics.hibernatedemo.dao.AppDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Hibernatedemo_one_to_one_bidirectionalApplication {

	public static void main(String[] args) {
		System.out.println("Inside Main Function of Spring Boot App");
		SpringApplication.run(Hibernatedemo_one_to_one_bidirectionalApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner->{
//			createInstructor(appDao);
			deleteInstructorDetailsById(appDao);
		};
	}

	private void deleteInstructorDetailsById(AppDao appDao) {
		int id=3;
		InstructorDetails instructorDetails=appDao.findInstructorDetailsById(id);
		System.out.println("Deleted "+instructorDetails);
		appDao.deleteInstructoryDetailsById(id);
	}
	private void findInstructorDetails(AppDao appDao) {
		int id=1;
		InstructorDetails instructorDetails=appDao.findInstructorDetailsById(id);
		System.out.println("Instructor Details "+instructorDetails);

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

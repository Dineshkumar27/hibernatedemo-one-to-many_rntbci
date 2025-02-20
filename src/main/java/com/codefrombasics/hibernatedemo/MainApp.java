package com.codefrombasics.hibernatedemo;

import com.codefrombasics.hibernatedemo.entity.Course;
import com.codefrombasics.hibernatedemo.entity.Instructor;
import com.codefrombasics.hibernatedemo.entity.InstructorDetails;
import com.codefrombasics.hibernatedemo.dao.AppDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		System.out.println("Inside Main Function of Spring Boot App");
		SpringApplication.run(MainApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner->{
//			createInstructor(appDao);
//			deleteInstructorDetailsById(appDao);
//			createInstructorWithCourses(appDao);
//			findInstructorWithCourses(appDao);
//			findCoursesForInstructor(appDao);
//			findCoursesForInstructorUsingJoinFetch(appDao);
//			updateInstructorLastName(appDao);
			updateCourseTitle(appDao);

		};
	}

	private void updateCourseTitle(AppDao appDao) {
		int id=10;
		appDao.updateCourseTitle(10);
		System.out.println("Updated Course id "+id);
	}

	private void updateInstructorLastName(AppDao appDao) {
		int id=1;
		appDao.updateInstructorLastName(id);


	}

	private void findCoursesForInstructorUsingJoinFetch(AppDao appDao) {
        int id=1;
		Instructor instructor=appDao.findCoursesForInstructorByFetchJoin(id);
		System.out.println("Instructor "+instructor);
		System.out.println("Courses of the instructor "+instructor.getCourses());

	}

	private void findCoursesForInstructor(AppDao appDao) {
		int id=1;
		//fetch the instructor with id
		Instructor instructor=appDao.findInstructorById(id);
		System.out.println("Instructor "+instructor);
		//get the list of course for the instructor
		List<Course> courses=appDao.findCoursesForInstructor(id);
		//assign the courses to particular instructor
		instructor.setCourses(courses);
		System.out.println("Courses for the instructor id "+id+" "+instructor.getCourses());


	}

	private void findInstructorWithCourses(AppDao appDao) {

		//get the instructor with id 1
		int id=1;
		Instructor instructor=appDao.findInstructorById(1);
		System.out.println("Instructor "+instructor);
		List<Course> coursesList=instructor.getCourses();
		System.out.println("Coursed Details "+coursesList);
	}

	private void createInstructorWithCourses(AppDao appDao) {

		//Create object for Instructor
		Instructor instructor=new Instructor("Naveen","Kumar","Naveen@gmail.com");

		//Create object for Instructor Details
		InstructorDetails instructorDetails=new InstructorDetails("www.yt.com/@mychannel","Games");

		instructor.setInstructorDetails(instructorDetails);

		//create 2 courses
		Course course1=new Course("Java Programming");
		Course course2=new Course("GO Programming");


		instructor.add(course1);
		instructor.add(course2);

		appDao.save(instructor);

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

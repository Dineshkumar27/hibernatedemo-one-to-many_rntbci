package com.codefrombasics.hibernatedemo.dao;

import com.codefrombasics.hibernatedemo.entity.Course;
import com.codefrombasics.hibernatedemo.entity.Instructor;
import com.codefrombasics.hibernatedemo.entity.InstructorDetails;

import java.util.List;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructoryById(int id);
    InstructorDetails findInstructorDetailsById(int id);
    void deleteInstructoryDetailsById(int id);
    List<Course> findCoursesForInstructor(int id);
    public Instructor findCoursesForInstructorByFetchJoin(int id);
    public void updateInstructorLastName(int id);
    public void updateCourseTitle(int id);
    Course findCourseById(int theId);
    void deleteCourseById(int theId);
}

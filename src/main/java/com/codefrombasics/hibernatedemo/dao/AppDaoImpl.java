package com.codefrombasics.hibernatedemo.dao;

import com.codefrombasics.hibernatedemo.entity.Course;
import com.codefrombasics.hibernatedemo.entity.Instructor;
import com.codefrombasics.hibernatedemo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao{
   private EntityManager entityManager;
    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructoryById(int id) {
        //fetch the instructor to delete
        Instructor theInstructor=entityManager.find(Instructor.class,id);
        //Delete the Instructor
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id) {
        return entityManager.find(InstructorDetails.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructoryDetailsById(int id) {
        //fetch the instructor details to delete
        InstructorDetails theInstructorDetails=entityManager.find(InstructorDetails.class,id);
        //Delete the Instructor
        theInstructorDetails.getInstructor().setInstructorDetails(null);
        entityManager.remove(theInstructorDetails);
    }

    @Override
    public List<Course> findCoursesForInstructor(int id) {

       TypedQuery<Course> query= entityManager.createQuery(
                 "from Course where instructor.id=:data", Course.class);
       query.setParameter("data",id);
       List<Course> coursesList=query.getResultList();
       return coursesList;

    }
    @Override
    public Instructor findCoursesForInstructorByFetchJoin(int id) {

             TypedQuery<Instructor> query=entityManager.createQuery(
                     "select i from Instructor i " +
                     "JOIN FETCH i.courses "+
                     "JOIN FETCH i.instructorDetails "+
                     "where i.id=:data",Instructor.class);
                   query.setParameter("data",id);
             Instructor instructor=query.getSingleResult();
             return  instructor;
    }
}

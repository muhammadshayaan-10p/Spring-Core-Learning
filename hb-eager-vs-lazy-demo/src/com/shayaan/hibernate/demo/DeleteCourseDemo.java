package com.shayaan.hibernate.demo;

import com.shayaan.demo.entity.Course;
import com.shayaan.demo.entity.Instructor;
import com.shayaan.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteCourseDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try{

            //start a transaction
            session.beginTransaction();

            //get a course
            int id =10;

            Course course = session.get(Course.class, id);
            System.out.println("Deleting Course: " + course);
            //delete the course

            session.delete(course);

            // commit the transaction
            session.getTransaction().commit();

        }finally {
            session.close();

            factory.close();
        }
    }
}

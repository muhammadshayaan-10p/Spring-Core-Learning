package com.shayaan.hibernate.demo;

import com.shayaan.demo.entity.Course;
import com.shayaan.demo.entity.Instructor;
import com.shayaan.demo.entity.InstructorDetail;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class fetchJoinDemo {

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

            int id = 1;

            Instructor instructor = session.get(Instructor.class, id);

            Query<Instructor> query = session.createQuery(
                    "SELECT i from Instructor i join fetch i.courses where i.id =: id", Instructor.class
            );
            session.close();

            // Retrieving Courses with HQL after session is closed

            List<Course> courses = instructor.getCourses();

            for (Course course : courses) {
                System.out.println(course);
            }
            // commit the transaction
            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}

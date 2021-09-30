package com.shayaan.hibernate.demo;

import com.shayaan.demo.entity.Instructor;
import com.shayaan.demo.entity.InstructorDetail;
import com.shayaan.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try{

            // create the objects

            Instructor instructor = new Instructor("Muhammad", "Ali Khan", "ali@gmail.com" );
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com", "Music");

            // associate the objects

            instructor.setInstructorDetail(instructorDetail);

            //start a transaction
            session.beginTransaction();

            // save the instructor
            // this will also save Instructor Detail object
            // because of CascadeType.all
            System.out.println("Saving .... " + instructor);
            session.save(instructor);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Instructor Saved in Database");

        }finally {
            factory.close();
        }
    }
}

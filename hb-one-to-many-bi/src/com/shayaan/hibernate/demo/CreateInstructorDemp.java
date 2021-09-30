package com.shayaan.hibernate.demo;

import com.shayaan.demo.entity.Course;
import com.shayaan.demo.entity.Instructor;
import com.shayaan.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemp {

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

            Instructor instructor = new Instructor("Muhammad", "shayaan", "abc@gmail.com");
            InstructorDetail details = new InstructorDetail("www.youtube.com", "Cricket");

            instructor.setInstructorDetail(details);

            session.save(instructor);
            // commit the transaction
            session.getTransaction().commit();
            session.close();

        }finally {
            factory.close();
        }
    }
}

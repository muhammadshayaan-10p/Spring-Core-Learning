package com.shayaan.hibernate.demo;

import com.shayaan.demo.entity.Instructor;
import com.shayaan.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

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

            //start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int id = 2;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            //print the details
            System.out.println(instructorDetail);

            // print the associated instructor
            System.out.println(instructorDetail.getInstructor());

            // commit the transaction
            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}

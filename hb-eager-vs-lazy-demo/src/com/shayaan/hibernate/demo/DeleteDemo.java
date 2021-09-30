package com.shayaan.hibernate.demo;

import com.shayaan.demo.entity.Instructor;
import com.shayaan.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

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

            // Get the instructor by their primary Id

            int theId = 3;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
            // the above code will return null if not found

            System.out.println("Found Instructor: " + (instructorDetail!=null));
            // delete the instructor

            if (instructorDetail != null){
                System.out.println("Deleting: " + instructorDetail);
                session.delete(instructorDetail);
            }

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Instructor Deleted from Database");

        }finally {
            factory.close();
        }
    }
}

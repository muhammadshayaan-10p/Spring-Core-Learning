package com.shayaan.hibernate.demo;

import com.shayaan.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try{
            // using the session object to save Java obj
            // create a student object
            System.out.println("Creating new student object");
            Student student= new Student("muhammad","shayaan", "abd@gmail.com");

            //start a transaction
            session.beginTransaction();

            // save the student obj
            session.save(student);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Student Saved in Database");

        }finally {
            factory.close();
        }
    }
}

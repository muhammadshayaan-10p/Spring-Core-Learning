package com.shayaan.hibernate.demo;

import com.shayaan.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

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
            System.out.println("Creating new student objects");

            Student student1= new Student("muhammad1","shayaan", "abd@gmail.com");
            Student student2= new Student("muhammad2","shayaan", "abd@gmail.com");
            Student student3= new Student("muhammad3","shayaan", "abd@gmail.com");

            //start a transaction
            session.beginTransaction();

            // save the student obj
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Student Saved in Database");

        }finally {
            factory.close();
        }

    }
}

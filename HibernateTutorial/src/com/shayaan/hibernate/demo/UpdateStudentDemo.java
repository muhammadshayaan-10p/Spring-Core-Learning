package com.shayaan.hibernate.demo;

import com.shayaan.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

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

            //start a transaction
            session.beginTransaction();

            //Update example for one student only
            //========================================

            int id =1;
            Student student = session.get(Student.class, id);

            student.setFirstName("Ali");

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Student Updated in Database");

            //update more than one students
            session = factory.getCurrentSession();

            session.beginTransaction();
            session.createQuery("update Student set email='foobar@gmail.com'").executeUpdate();
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}

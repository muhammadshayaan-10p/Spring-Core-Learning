package com.shayaan.hibernate.demo;

import com.shayaan.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

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

            session = factory.getCurrentSession();

            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").getResultList();
            System.out.println("List of students: ");

            displayStudents(theStudents);


            //query students with last name "shayaan"

            theStudents = session.createQuery("from Student s where s.lastName = 'Shayaan'").getResultList();

            System.out.println("Selected Students: ");

            displayStudents(theStudents);

            //commit the transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student temp : theStudents){
            System.out.println(temp);

        }
    }
}

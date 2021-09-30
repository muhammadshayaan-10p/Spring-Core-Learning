package com.shayaan.hibernate.demo;

import com.shayaan.demo.entity.Course;
import com.shayaan.demo.entity.Instructor;
import com.shayaan.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemp {

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

            // get the instructor from db
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            // create some courses
            Course c1 = new Course("Maths");
            Course c2 = new Course("programming");

            // add courses to the instructor

            instructor.addCourse(c1);
            instructor.addCourse(c2);


            //save the courses
            session.save(c1);
            session.save(c2);

            // commit the transaction
            session.getTransaction().commit();
            session.close();

        }finally {
            factory.close();
        }
    }
}

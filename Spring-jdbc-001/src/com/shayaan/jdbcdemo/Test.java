package com.shayaan.jdbcdemo;

import com.shayaan.dao.StudentDAO;
import com.shayaan.dao.StudentDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentDAO studentDAO = context.getBean("studentDao", StudentDAO.class);

//        Student s1 = new Student();
//        s1.setRollNo(002);
//        s1.setName("Shayaan1");
//        s1.setAddress("Gulistan e Johar 1 ");
//
//        studentDAO.insert(s1);

        ArrayList<Student> studentList = new ArrayList<>();
//        studentList.add();
    }
}

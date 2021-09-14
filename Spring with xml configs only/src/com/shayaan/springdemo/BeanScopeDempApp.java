package com.shayaan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDempApp {
    public static void main(String[] args) {

        //load the spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //retrieve the bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // check if they are the same beans

        boolean result = (theCoach == alphaCoach);
        System.out.println("Pointing to the same location: " + result);
        System.out.println("Memory location of theCoach: " + theCoach + " alpha coach : " + alphaCoach);

        context.close();
    }
}

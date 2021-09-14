package com.shayaan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from the spring container

        Coach coach = context.getBean("theSillyCoach", Coach.class);

        // call a method on the bean
        System.out.println(coach.getdailyWorkout());
        System.out.println(coach.getDailyFortune());
        // close the context
        context.close();


    }
}

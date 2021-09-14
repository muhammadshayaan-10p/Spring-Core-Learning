package com.shayaan.springaop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shayaan.springaop.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {


			
	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		

		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);

		
		// close the context
		context.close();
	}

}











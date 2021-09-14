package com.shayaan.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//Default bean id will be "tennisCoach"
@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    //Constructor Injection
    //@Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getdailyWorkout() {
        return "Practice your back hand shot";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune() ;
    }


}

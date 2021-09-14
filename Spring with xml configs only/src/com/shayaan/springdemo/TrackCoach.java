package com.shayaan.springdemo;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout(){
        return "Do 50 push-ups";
    }

    @Override
    public String getDailyFortune() {
        return "just do it " + fortuneService.getFortune();

    }

    //add an init method
    public void doMyStartupStuff(){
        System.out.println("Track Coach: inside init method");
    }

    // add a destroy method
    public void doMyCleanupStuff(){
        System.out.println("Track Coach: inside destroy method");
    }
}

package com.practice.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Fast bowling for 15 minutes";
    }
    public String helloThere(){
        return "I am from class";
    }
}

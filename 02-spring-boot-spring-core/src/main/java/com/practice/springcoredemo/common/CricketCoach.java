package com.practice.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "<h1>Fast bowling for 15 minutes</h1>";
    }
    public String helloThere(){
        return "<h1>I am from class</h1>";
    }
}

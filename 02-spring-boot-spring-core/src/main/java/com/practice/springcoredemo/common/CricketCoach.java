package com.practice.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
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

    //our init method
    @PostConstruct
    public void helloThere(){
        System.out.println("I am from hello there, class = " + getClass().getSimpleName());
    }

    // our destroy method
    @PreDestroy
    public void helloTherePreDestroy(){
        System.out.println("I am from helloTherePreDestroy(), class = " + getClass().getSimpleName());
    }
}

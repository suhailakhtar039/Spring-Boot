package com.practice.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "<h1>From Baseball</h1>";
    }
}

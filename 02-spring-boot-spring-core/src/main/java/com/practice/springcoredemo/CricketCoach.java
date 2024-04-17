package com.practice.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoack implements Coack {
    @Override
    public String getDailyWorkout() {
        return "Fast bowling for 15 minutes";
    }
}

package com.practice.springcoredemo.config;

import com.practice.springcoredemo.common.Coach;
import com.practice.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }

}

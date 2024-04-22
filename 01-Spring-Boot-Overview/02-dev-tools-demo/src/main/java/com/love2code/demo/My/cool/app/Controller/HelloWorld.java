package com.love2code.demo.My.cool.app.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String index(){
        return "coach is " + coachName + " team is " + teamName;
    }

//    expose new endpoint
    @GetMapping("/hello")
    public String getHello(){
        return "<h1>Working correctly<h1>";
    }
}

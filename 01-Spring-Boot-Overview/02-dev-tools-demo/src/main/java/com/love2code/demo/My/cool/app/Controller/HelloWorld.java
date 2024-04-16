package com.love2code.demo.My.cool.app.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String index(){
        return "Hello world";
    }

//    expose new endpoint
    @GetMapping("/hello")
    public String getHello(){
        return "<h1>Working correctly<h1>";
    }
}

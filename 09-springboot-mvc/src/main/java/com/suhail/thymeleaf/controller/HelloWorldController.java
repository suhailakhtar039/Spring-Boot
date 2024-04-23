package com.suhail.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // @RequestMapping("")
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model) {

        String name = request.getParameter("studentName");

        name = name.toUpperCase();

        String ans = "Yo " + name;
        model.addAttribute("message", ans);
        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String studentName, Model model) {

        String name = studentName;

        name = name.toUpperCase();

        String ans = "Yo " + name;
        model.addAttribute("message", ans);
        return "helloworld";
    }

}


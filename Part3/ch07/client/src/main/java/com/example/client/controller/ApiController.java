package com.example.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApiController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}

package com.example.Part3.controller;

import com.example.Part3.dto.UserReq;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping
    public UserReq user(UserReq userReq) {
        return userReq;
    }
}

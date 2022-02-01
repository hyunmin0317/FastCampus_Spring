package com.example.client.controller;

import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApiController {

    private final RestTemplateService restTemplateService;

    public ApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    //    @Autowired
    //    private RestTemplateService restTemplateService;

    @GetMapping("/hello")
    public String getHello() {
        return restTemplateService.hello();
    }

    @GetMapping("hello2")
    public UserResponse getHello2() {
        return restTemplateService.post();
    }

}

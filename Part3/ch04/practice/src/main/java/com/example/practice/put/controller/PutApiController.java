package com.example.practice.put.controller;

import com.example.practice.put.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto) {
        System.out.println(requestDto);
        return requestDto;
    }
}

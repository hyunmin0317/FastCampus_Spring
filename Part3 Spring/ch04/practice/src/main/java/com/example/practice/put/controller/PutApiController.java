package com.example.practice.put.controller;

import com.example.practice.put.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto) {
        System.out.println(requestDto);
        return requestDto;
    }

    @PutMapping("/put/{userId}")
    public PostRequestDto put2(@RequestBody PostRequestDto requestDto, @PathVariable Long userId) {
        // @PathVariable("userId") Long id

        System.out.println(userId);
        return requestDto;
    }
}

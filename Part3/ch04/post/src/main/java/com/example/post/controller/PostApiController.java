package com.example.post.controller;

import com.example.post.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/")
public class PostApiController {

    // 1. Key가 정해지지 않은 경우
    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {
        requestData.entrySet().forEach(stringObjectEntry -> {
            System.out.println("key : "+stringObjectEntry.getKey());
            System.out.println("value : "+stringObjectEntry.getValue());
        });

//        간결한 표현
//        requestData.forEach((key, value) -> {
//            System.out.println("key : " + key);
//            System.out.println("value : " + value);
//        });
    }

    // 2. Key가 정해진 경우
    @PostMapping("/post2")
    public void post(@RequestBody PostRequestDto requestData) {
        System.out.println(requestData);
    }
}
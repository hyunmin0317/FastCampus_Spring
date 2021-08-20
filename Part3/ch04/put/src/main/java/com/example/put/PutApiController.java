package com.example.put;

import com.example.put.dto.PostRequestDto;
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
    public PostRequestDto put(@RequestBody PostRequestDto requestDto, @PathVariable Long userId) {
        System.out.println(userId);
        return requestDto;
    }
}

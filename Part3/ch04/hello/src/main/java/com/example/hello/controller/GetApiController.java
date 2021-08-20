package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")    // http://localhost:9090/api/get/hello
    public String hello(){
        return "get Hello";
    }

//    @RequestMapping("/hi")      // get, post, put, delete 모두 동작
    @RequestMapping(path = "/hi", method = RequestMethod.GET)   // get
    public String hi() {
        return "hi";
    }

    // Path Variable
    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable : "+name);
        return name;
    }

    @GetMapping("/path-variable2/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName, String name) {
        System.out.println("PathVariable : "+pathName);
        return pathName;
    }
}

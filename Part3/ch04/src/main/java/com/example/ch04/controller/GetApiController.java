package com.example.ch04.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")    // http://localhost:8080/api/get/hello
    public String getHello(){
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)   // get http://localhost:8080/api/get/hi
    public String hi(){
        return "hi";
    }

//     http://localhost:8080/api/get/path-variable/{name}
//    @GetMapping("/path-variable/{name}")
//    public String pathVariable(@PathVariable(name = "name") String pathName, String name){
//        System.out.println("PathVariable : "+pathName);
//        return pathName;
//    }

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("PathVariable : "+name);
        return name;
    }

//     http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30


    // Query
    // ?key=value&key2=value2


}

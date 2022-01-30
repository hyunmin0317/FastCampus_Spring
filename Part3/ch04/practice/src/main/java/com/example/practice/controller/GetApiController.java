package com.example.practice.controller;

import com.example.practice.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    // http://localhost:8080/api/get/hello
    @GetMapping(path = "/hello")
    public String getHello() {
        return "get Hello";
    }

//    @RequestMapping(path = "/hi")    // get / post / put / delete

    // http://localhost:8080/api/get/hi
    @RequestMapping(path = "/hi", method = RequestMethod.GET)    // get
    public String hi() {
        return "get Hello";
    }

    // http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable: "+name);
        return name;
    }

    // http://localhost:8080/api/get/path-variable2/{name}
    @GetMapping("/path-variable2/{name}")
    public String pathVariable2(@PathVariable(name = "name") String pathName) {
        System.out.println("PathVariable: "+pathName);
        return pathName;
    }

    // http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });
        return sb.toString();
    }

    // http://localhost:8080/api/get/query-param2?name=steve&email=steve@gmail.com&age=30
    @GetMapping("/query-param2")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+" "+email+" "+age;
    }

    // http://localhost:8080/api/get/query-param3?name=steve&email=steve@gmail.com&age=30
    @GetMapping("/query-param3")
    public String queryParam3(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }
}

package com.practice.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSon을 반환하는 controller
public class HelloController {
    @GetMapping("/hello") //HTTP METHOD GET의 요청을 받을 수 있음
    public String hello(){
        return "hello";
    }
}

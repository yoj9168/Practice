package com.practice.springboot.web;

import com.practice.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSon을 반환하는 controller
public class HelloController {
    @GetMapping("/hello") //HTTP METHOD GET의 요청을 받을 수 있음
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){ //외부에서 api 넘긴 파라미터 가져오기
        //localhost:8080/hello/dto?name=ojun&amount=1000
        return new HelloResponseDto(name,amount); //그러면 Json 형태로 {"name":"ojun","amount":1000} 뱉어줌
    }

}

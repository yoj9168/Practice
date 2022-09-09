package com.practice.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //스프링 부트 테스트와 JUnit(자바의 단위 테스트 프레임워크)사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc; //API 테스트에 활용, GET과 POST에 대한 API 테스트 가능

    @Test
    public void hello() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")).
                andExpect(status().isOk()).
                andExpect(content().string(hello));
    }
}

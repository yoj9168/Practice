package com.practice.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //스프링 부트 테스트와 JUnit(자바의 단위 테스트 프레임워크)사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 빈을 주입받음
    private MockMvc mvc; //API 테스트에 활용, GET과 POST에 대한 API 테스트 가능
    @Test
    public void helloTest() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")).
                andExpect(status().isOk()).
                andExpect(content().string(hello));
    }
    @Test
    public void helloDtoTest() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("amount",String.valueOf(amount))) //값은 string만 허용, 그니까 localhost:8080/hello/dto?name=hello&amount=1000으로 들어갈게
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) //json 응답값을 필드별로 검증
                .andExpect(jsonPath("$.amount",is(amount))); //내가 보내준 json의 amount값과 내가 선언한 amount가 같니?
    }
}

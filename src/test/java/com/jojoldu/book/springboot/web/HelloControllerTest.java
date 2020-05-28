package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 1 RunWith
// 테스트를 진행할 때 Jnit 에 내장된 실행자 외에 다른 실행자를 실행 시킵니다.
// 여기서는 SpringRunner 라는 스프링 실행자를 사용합니다.
// 즉, 스프링 부트 테스트와 Jnuit 의 연결자 역할을 합니다.
@RunWith(SpringRunner.class)
// 2 WebMvcTest
// 여러 스프링 어노테이션 중 MVC(spring MVC) 에 집중할 수 잇는 어노테이션입니다.
// 선언할 경우 @Controller, @ControllerAdvie 등을 사용할 수 있습니다.
// 단, @Service, Component, Repository 등은 사용할 수 없다.
// 여기서는 컨트롤러만 사용하기 때문에 선언한다.
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    // 3 @Autowired
    // 스프링이 관리하는 빈을 주입받습니다.
    @Autowired
    // 4 private MockMvc mvc
    // 웹 api 를 테스트 할 때 사용합니다.
    // 스프링 MVC 테스트의 시작점입니다.
    // 이 클래스를 통해 HTTP, GET, POST 등에 대한 api 테스트를 할 수 있습니다.
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // 5
        // MockMvc 를 통해 /hello 주소로 HTTP GET 요청을 합니다.
        // 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있습니다.
        mvc.perform(get("/hello"))
                // 6
                //mvc.perform 의 결과를 검증합니다.
                // HTTP 헤더의 Status 를 검증합니다. 우리가 흔히 알고 있는 200,404,500 등의 상태를 점검
                // 여기선 OK 인지 200인지 아닌지를 검증합니다.
                .andExpect(status().isOk())
                // 7
                //mvc.perform 의 결과를 검증합니다.
                // 응답 본문의 내용을 검증합니다.
                // Controller 에서 'hello'를 리턴하기 때문에 이 값이 맞는지를 검증한다.
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        // param
        // api 테스트할 때 사용될 파라미터 설정, 값은 String만 허용됩니다.
        // 그래서 숫자 날짜 같은 데이터도 등록할 때는 문자열로 변경해야만 가능합니다.
        // jsonPath
        // json 응답값을 필드별로 검증할 수 있는 메소드입니다.
        // $를 기준으로 필드명을 명시합니다.
        mvc.perform(
                get("/hello/dto")
                        .param("name",name)//
                        .param("amount",String.valueOf(amount)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name",is(name)))//
                        .andExpect(jsonPath("$.amount",is(amount)));
    }

}

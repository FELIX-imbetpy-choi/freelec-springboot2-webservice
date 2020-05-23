package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControlller {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}

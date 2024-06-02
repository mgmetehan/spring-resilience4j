package com.mgmetehan.springresilience4j.retry.controller;

import com.mgmetehan.springresilience4j.retry.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MyController {

    private final MyService myService;

    @GetMapping("/doSomething")
    public String doSomething() {
        try {
            return myService.doSomething();
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}

package com.example.hahowspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/status")
@RestController
public class StatusController {

    @RequestMapping("/test")
    public String test(){
        return "Hello World";
    }
    @RequestMapping("/test2")
    public ResponseEntity<String> test2(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
    }
    @RequestMapping("/test3")
    public String test3(){
        throw new RuntimeException("test3 exception");
    }

    @RequestMapping("/test4")
    public String test4(){
        throw new IllegalArgumentException("test4 exception");
    }
}

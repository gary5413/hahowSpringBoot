package com.example.hahowspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handler(RuntimeException exception){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("RuntimeException:"+exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handler(IllegalArgumentException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("IllegalArgumentException:"+exception.getMessage());
    }

}

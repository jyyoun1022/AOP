package com.codej.AOP.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice//모든 예외를 관리
public class MyExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public String requestException(IllegalArgumentException e){
        return "오류 :"+ e.getMessage();
    }

}

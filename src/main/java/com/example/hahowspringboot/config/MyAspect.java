package com.example.hahowspringboot.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspect {

//    @Before("execution(* com.example.hahowspringboot.modle.HpPrinter.*(..))")
//    public void before(){
//        System.out.println("I'm before");
//    }
//
//    @After("execution(* com.example.hahowspringboot.modle.HpPrinter.*(..))")
//    public void after(){
//        System.out.println("I'm after");
//    }
    @Around("execution(* com.example.hahowspringboot.model.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("I'm around before");
        Date start = new Date();
        Object obj=pjp.proceed();
        System.out.println("I'm around after");
        Date end=new Date();
        long time =end.getTime()-start.getTime();
        System.out.println("總共執行："+time+"ms");
        return obj;
    }
}
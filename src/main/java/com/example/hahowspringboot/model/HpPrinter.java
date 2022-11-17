package com.example.hahowspringboot.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 抖紅字 option + enter
@Component
public class HpPrinter implements Printer {
    @Value("${printer.name}")
    private String name;
    @Value("${printer.count:20}")
    private int count;
//    @PostConstruct
//    public void init(){
//        count=5;
//    }
    @Override
    public void print(String message) {
        System.out.println("HP印表機："+message);
        count--;
////        System.out.println("HP印表機："+message);
        System.out.println(name+":"+message);
        System.out.println("剩餘次數："+count);
    }

}

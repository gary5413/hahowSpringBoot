package com.example.hahowspringboot.controller;

import com.example.hahowspringboot.model.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
//    @Qualifier("canonPrinter")
    @Autowired
    private Printer printer; //還沒加@Qualifier前會抖紅字 不知道你要使用哪個bean
/*
1.沒指定會bena類型報錯 不知道你要使用哪個bean
answer:加@Qualifier注釋
Field printer in com.example.hahowspringboot.controller.MyController required a single bean, but 2 were found:

2.找不到該類型的 Spring Bean
answer:再class上面加@Compoent
Field printer in com.example.hahowspringboot.controller.MyController required a bean of type 'com.example.hahowspringboot.modle.Printer' that could not be found.
 */
    @RequestMapping("/test")
    public String test(){
//        System.out.println("Hi SpringBoot");
        printer.print("Hello Spring bean");
        return "Hello SpringBoot";
    }
}

package com.example.hahowspringboot.controller;

import com.example.hahowspringboot.model.Store;
import com.example.hahowspringboot.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("/detail")
@RestController
public class TestContoller {

    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id){
        System.out.println("id:"+id);
        return "hello test1";
    }
    @RequestMapping("/test2")
    public String test2(@RequestParam(defaultValue = "87") Integer id,
                        @RequestParam(required = false) String name){
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        return "hello test2";
    }

    @RequestMapping("/test3")
    public String test3(@RequestBody Student student){
        System.out.println("student id:"+student.getId());
        System.out.println("student name:"+student.getName());
        return "hello test3";
    }

    @RequestMapping("/test4")
    public String test4(@RequestHeader String info){
        System.out.println("header info:"+info);
        return "hello test4";
    }

    @RequestMapping("/test5/{id}/{name}")
    public String test5(@PathVariable Integer id,
                        @PathVariable String name){
        System.out.println("path id:"+id);
        System.out.println("path name:"+name);
        return "hello test5";
    }


    @RequestMapping("/product")
    public String product(){
        return "第一個是apple，第二個是orange";
    }

    @RequestMapping("/user")
    public Student user(){
//        option + command +v 取變數
        Student student = new Student();
        student.setName("Gary");
        return student;
    }
    @RequestMapping("/store")
    public Store store(){
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("orange");
        store.setProductList(list);
        return store;
    }
}

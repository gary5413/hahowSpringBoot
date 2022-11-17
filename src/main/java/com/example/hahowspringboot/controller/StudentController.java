package com.example.hahowspringboot.controller;

import com.example.hahowspringboot.model.Student;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {

//    @RequestMapping(value="/students",method = RequestMethod.POST)
    @PostMapping("/students")
    public String create(@RequestBody @Valid Student student){
//        if(student.getId()==null){
//            throw new RuntimeException("id 不可為 null");
//        }
        return "執行資料庫的 Create操作";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable  Integer studentId){
        return "執行資料庫 Read操作";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student,
                         @RequestHeader String info){
        return "執行資料庫 Update操作";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId){
        return "執行資料庫 Delete操作";
    }



}

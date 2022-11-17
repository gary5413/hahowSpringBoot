package com.example.hahowspringboot.controller.jpa;

import com.example.hahowspringboot.model.jpa.StudentJpa;
import com.example.hahowspringboot.model.jpa.StudnetJpaReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentJpaController {

    @Autowired
    private StudnetJpaReposiotry studnetJpaReposiotry;

    @PostMapping("/studentsJpa")
    public String insert(@RequestBody StudentJpa studentJpa){
        studnetJpaReposiotry.save(studentJpa);
        return "執行資料庫的Create";
    }

    @GetMapping("/studentsJpa/{studentId}")
    public StudentJpa read(@PathVariable Integer studentId){

        StudentJpa student=studnetJpaReposiotry.findById(studentId).orElse(null);
        return  student;
    }

    @PostMapping("/studentsJpa/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody StudentJpa student){
        StudentJpa s=studnetJpaReposiotry.findById(studentId).orElse(null);
        if(s!=null){
            s.setName(student.getName());
            studnetJpaReposiotry.save(s);
            return "執行資料庫Update";
        }else{
            return "Update失敗數據不存在";
        }
    }

    @DeleteMapping("/studentsJpa/{studentId}")
    public String delete(@PathVariable Integer studentId){
        studnetJpaReposiotry.deleteById(studentId);
        return "執行資料庫Delete操作";
    }

}

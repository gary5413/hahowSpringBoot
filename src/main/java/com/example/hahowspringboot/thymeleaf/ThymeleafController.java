package com.example.hahowspringboot.thymeleaf;

import com.example.hahowspringboot.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//注意是加Controller註解 不是RestController
@Controller
public class ThymeleafController {
    @GetMapping("/home")
    public String home(){
        return "index";
    }
    @GetMapping("/home2")
    public String home(Model model){
        Student student = new Student();
        student.setName("Gary");
        student.setId(123);
        model.addAttribute("myStudent",student);
        return "index";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @PostMapping("/login")
    public String login(String userName,
                        String userPassword){
        System.out.println("userName:"+userName);
        System.out.println("userPassword:"+userPassword);;
        return "login";
    }
}

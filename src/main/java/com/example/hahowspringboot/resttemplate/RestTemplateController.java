package com.example.hahowspringboot.resttemplate;

import com.example.hahowspringboot.model.Student;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class RestTemplateController {
    String url="https://mocki.io/v1/bebf922e-23f0-40ec-8bd3-91bedb6db7a0";
    String url1="https://mocki.io/v1/ffd6881e-ef0d-4564-b38d-8b234fb6bf97";
    @GetMapping("/getForObject")
    public String getForObject(){
        RestTemplate restTemplate = new RestTemplate();
        Book book=restTemplate.getForObject(url1,Book.class);
        System.out.println("book id:"+book.getId());
        System.out.println("book name:"+book.getName());
        System.out.println("book author:"+book.getBookAuthor());
        return "getForObject success";
    }
    @GetMapping("/getForObjectWithParam")
    public String getForObjectWithParam(){
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, Object> queryParamMap = new HashMap<>();
        queryParamMap.put("graduate",true);
        Book book=restTemplate.getForObject(url1,Book.class,queryParamMap);
        return "getForObjectWithParam success";
    }
    @GetMapping("/getForEntity")
    public String getForEntity(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book> bookEntity = restTemplate.getForEntity(url1,Book.class);
        System.out.println("狀態碼："+bookEntity.getStatusCode());
        Book book = bookEntity.getBody();
        System.out.println("book id:"+book.getId());
        return "getForEntity success";
    }
    @PostMapping("/postForObject")
    public String postForObject(){
        RestTemplate restTemplate = new RestTemplate();
        Book bookRequestBody = new Book();
        bookRequestBody.setName("Ian");
        Book result = restTemplate.postForObject(url1, bookRequestBody, Book.class);
        return "postForObject success";
    }
    @PostMapping("/post")
    public String postForEntity(){
        RestTemplate restTemplate = new RestTemplate();
        Book bookRequestBody = new Book();
        bookRequestBody.setName("EEIT");
        ResponseEntity<Book> responseEntity = restTemplate.postForEntity(
                url1, bookRequestBody, Book.class);
        return "postForEntity success";
    }
    @GetMapping("/exchange")
    public String exchange(){
        RestTemplate restTemplate = new RestTemplate();
//      使用 exchange 發起Get請求
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("header1","123");
        HttpEntity requestEntity = new HttpEntity(requestHeaders);
        HashMap<String, Object> queryParamMap = new HashMap<>();
        queryParamMap.put("graduate",true);
        restTemplate.exchange(url1, HttpMethod.GET,
                requestEntity,
                Book.class,
                queryParamMap);
//      使用 exchange 發起Post請求
        HttpHeaders requestHeaders2 = new HttpHeaders();
        requestHeaders2.set("header2","456");
        requestHeaders2.setContentType(MediaType.APPLICATION_JSON);
        Book bookRequestBody = new Book();
        bookRequestBody.setName("iSpan");
        HttpEntity requestEntity2=new HttpEntity(bookRequestBody, requestHeaders2);
        restTemplate.exchange(url1,
                HttpMethod.POST,
                requestEntity2,
                Book.class);
        return "exchange success";
    };

}

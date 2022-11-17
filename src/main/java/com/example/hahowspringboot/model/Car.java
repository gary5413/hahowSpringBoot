package com.example.hahowspringboot.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private Integer id;
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.example.hahowspringboot.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student {
    @NotBlank
    String name;
    @NotNull
    Integer id;

//    command + n
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

    //    Integer id;
//    String name;
//    Double score;
//    boolean graduated;
//    Integer age;
//    List<String> courseList;
//    Pet pet;
//    List<Pet> petList;
}

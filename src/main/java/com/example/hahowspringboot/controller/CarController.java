package com.example.hahowspringboot.controller;

import com.example.hahowspringboot.model.Car;
import com.example.hahowspringboot.model.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
//    使用Interface類型
    @Autowired
    private CarService carService;

    @GetMapping("/cars/{carId}")
    public Car selectById(@PathVariable Integer carId){
        return carService.getById(carId);
    }
}

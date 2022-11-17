package com.example.hahowspringboot.model.dao;

import com.example.hahowspringboot.model.Car;

import java.util.List;

public interface CarDao {
    public Car getById(Integer carId);

    public List<Car> queryAll();

//    public String insert(Car car);
//
//    public String updateById(Car car);
//
//    public String deleteById(Integer carId);
}

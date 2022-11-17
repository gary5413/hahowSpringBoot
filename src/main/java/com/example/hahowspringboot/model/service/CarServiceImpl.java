package com.example.hahowspringboot.model.service;

import com.example.hahowspringboot.model.Car;
import com.example.hahowspringboot.model.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarServiceImpl implements CarService {
//   使用Interface作為變數類型
//    Autowired 會使用變數的類型 所有實現carDao這個interface class 透過Java多行特性
//    假設刪除 CarDaoImpl 改新的 New CarDaoImpl 也不會出錯 降低class之間的耦合度
//    快速瀏覽方法和規定方法 實現重複使用增加效率
    @Autowired
    private CarDao carDao;

    public Car getById(Integer carId){
        return carDao.getById(carId);
    }
}

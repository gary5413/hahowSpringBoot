package com.example.hahowspringboot.model.dao;

import com.example.hahowspringboot.model.Car;
import com.example.hahowspringboot.model.CarRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CarDaoImpl implements CarDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Car getById(Integer carId){
        String sql="SELECT id,name FROM car WHERE id=:carId";
        Map<String,Object> map =new HashMap<>();
        map.put("carId",carId);
        List<Car> list=namedParameterJdbcTemplate.query(sql,map,new CarRowMapper());
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<Car> queryAll() {
        String sql="SELECT id,name FROM car";
        Map<String,Object> map=new HashMap<>();
        List<Car> list=namedParameterJdbcTemplate.query(sql,map,new CarRowMapper());
        return list;
    }



}

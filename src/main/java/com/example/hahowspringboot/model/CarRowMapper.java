package com.example.hahowspringboot.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setName(rs.getString("name"));
        return car;
    }
}

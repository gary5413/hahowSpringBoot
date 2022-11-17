package com.example.hahowspringboot.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
/*
ResultSet rs 從資料庫中查詢出來的數據
返回值 Student 將資料庫的數據轉換成哪種類型的Java Object
 */
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        return student;
    }
}

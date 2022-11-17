package com.example.hahowspringboot.controller;

import com.example.hahowspringboot.model.Student;
import com.example.hahowspringboot.model.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

//    抖黃 抖紅 是因為 @SpringBootApplication 不影響
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/jdbc_selectById/{studentId}")
    public Student selectById(@PathVariable Integer studentId){
        String sql="SELECT id,name FROM student where id=:studentId";
        Map<String,Object> map=new HashMap<>();
        map.put("studentId",studentId);
        List<Student> list= namedParameterJdbcTemplate.query(sql,map,new StudentRowMapper());
//    取出第一個list 也是唯一一個
//        return list.get(0);
//        如果傳回無此 id 會爆出 indexoutofbounds
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    @GetMapping("/jdbc_selectAll")
    public List<Student> selectAll(){
//      建議不要用＊
//      1.額外網路量 2.資料庫查詢速度無法提升
        String sql="SELECT id,name FROM student_demo2";
        Map<String,Object> map=new HashMap<>();
        List<Student> list= namedParameterJdbcTemplate.query(sql,map,new StudentRowMapper());
        return list;
    }

//    要如何大量的執行一批INSERT
    @PostMapping("/jdbc_insert4_batch")
    public String insertList(@RequestBody List<Student> studentList){
        String sql="INSERT INTO student_demo2(name) VALUE(:studentName)";
        MapSqlParameterSource[] parameterSources =new MapSqlParameterSource[studentList.size()];
        for(int i=0;i<studentList.size();i++){
            Student student=studentList.get(i);
            parameterSources[i]=new MapSqlParameterSource();
            parameterSources[i].addValue("studentName",student.getName());
        }
        namedParameterJdbcTemplate.batchUpdate(sql,parameterSources);

        return "執行一批 INSERT sql";
    }

//    當table的id會自動增加時，要如何去取得id的值
    @PostMapping("/jdbc_insert3_demo2")
    public String insert_student_demo2(@RequestBody Student student){
        String sql="INSERT INTO student_demo2(name) VALUE (:studentName)";
        HashMap<String, Object> map = new HashMap<>();
        map.put("studentName",student.getName());
        KeyHolder keyHolder =new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
        int id=keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成 id 為："+id);
        return "執行 INSERT sql";
    }



    @PostMapping("/jdbc_insert")
    public String insert(){
        String sql="INSERT INTO student(id,name) VALUE (3,'Gary')";
        HashMap<String, Object> map = new HashMap<>();
        namedParameterJdbcTemplate.update(sql,map);
        return "執行 INSERT sql";
    }

    @PostMapping("/jdbc_insert2")
    public String insert2(@RequestBody Student student){
        String sql="INSERT INTO student(id,name) VALUE (:studentId,:studentName)";
        HashMap<String, Object> map = new HashMap<>();
        map.put("studentId",student.getId());
        map.put("studentName",student.getName());
        namedParameterJdbcTemplate.update(sql,map);
        return "執行 INSERT sql";
    }

    @DeleteMapping("/jdbc/{studentId}")
    public String delete(@PathVariable Integer studentId){
        String sql="DELETE FROM student WHERE id =:studentId";
        HashMap<String, Object> map = new HashMap<>();
        map.put("studentId",studentId);
        namedParameterJdbcTemplate.update(sql,map);
        return "執行 delete sql";
    }


}

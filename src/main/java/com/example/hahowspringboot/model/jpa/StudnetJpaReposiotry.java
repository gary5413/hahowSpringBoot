package com.example.hahowspringboot.model.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudnetJpaReposiotry extends CrudRepository<StudentJpa,Integer> {

    List<StudentJpa> findByName(String name);

    StudentJpa findByIdAndName(Integer id,String name);

    @Query(value = "SELECT id,name FROM studnet WHERE id =?1 AND name = ?2",nativeQuery = true)
    StudentJpa getByIdAndName(Integer id,String name);

}

package com.example.hahowspringboot.model.jpa;

import javax.persistence.*;

@Entity
@Table(name="student_JPA")
public class StudentJpa {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String name;

    public StudentJpa() {
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

package com.example.hahowspringboot.resttemplate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    Integer id;
    String name;
    @JsonProperty("book_author")
    String bookAuthor;

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
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

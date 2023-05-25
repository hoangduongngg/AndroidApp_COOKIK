package com.example.cookik_app.model;

public class Shelf {
    private Integer id;
    private String name;

    public Shelf(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Shelf(String name) {
        this.name = name;
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

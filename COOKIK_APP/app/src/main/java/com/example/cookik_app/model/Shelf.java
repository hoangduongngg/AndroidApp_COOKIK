package com.example.cookik_app.model;

import java.io.Serializable;

public class Shelf implements Serializable {
    private Integer id;
    private String name;

    public Shelf(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Shelf(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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

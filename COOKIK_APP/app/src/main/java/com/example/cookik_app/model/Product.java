package com.example.cookik_app.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Getter

public class Product {
    private Integer id;
    private String name;
    private String img;
    private Integer price;
    private int quantity;
    private String description;
    private String expirationDate;
    private int idSupplier;

    public String getName() {
        return name;
    }
}

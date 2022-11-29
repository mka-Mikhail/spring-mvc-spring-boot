package com.mka.springmvcspringboot.models;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String title;
    private int cost;

    public Product(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }

    public Product() {

    }
}

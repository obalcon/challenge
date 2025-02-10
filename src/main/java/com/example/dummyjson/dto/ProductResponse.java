package com.example.dummyjson.dto;

import java.util.List;

public class ProductResponse {
    private List<Product> products;

    // Getters e Setters
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
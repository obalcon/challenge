package com.example.dummyjson.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;

@Service
public class ProductService {

    private final WebClient webClient;

    private final String BASE_URL = "https://dummyjson.com/products";

    @Autowired
    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    public List<Product> getAllProducts() {
        ProductResponse response = webClient
            .get()
            .retrieve()
            .bodyToMono(ProductResponse.class)
            .block();
        return response != null ? response.getProducts() : new ArrayList<>();
    }
    public Product getProductById(Long id) {
        String url = "/" + id;
        return webClient
            .get()
            .uri(url)
            .retrieve()
            .bodyToMono(Product.class)
            .block();
    }

}

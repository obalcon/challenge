package com.example.dummyjson.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.dummyjson.dto.Product;

import jakarta.annotation.PostConstruct;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    private static final String BASE_URL = "http://localhost:8000/api/products";

 /*   
    public static void main(String[] args) {
    	ProductControllerTest test = new ProductControllerTest();
        test.runTests();
    }
   */ 
    @PostConstruct
    public void runTests() {
        testGetProductById();
        testGetAllProducts();
    }
    private void testGetAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product[]> response = restTemplate.getForEntity(BASE_URL, Product[].class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            List<Product> products = Arrays.asList(response.getBody());
            System.out.println("✅ testGetAllProducts PASSED: " + products);
        } else {
            System.out.println("❌ testGetAllProducts FAILED: HTTP " + response.getStatusCode());
        }
    }

    private void testGetProductById() {
        RestTemplate restTemplate = new RestTemplate();
        Long productId = 1L; // Defina um ID válido para testar
        String url = BASE_URL + "/" + productId;

        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            System.out.println("✅ testGetProductById PASSED: " + response.getBody());
        } else {
            System.out.println("❌ testGetProductById FAILED: HTTP " + response.getStatusCode());
        }
    }
}

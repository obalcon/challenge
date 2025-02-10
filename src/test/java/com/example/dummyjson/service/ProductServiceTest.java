package com.example.dummyjson.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dummyjson.dto.Product;

import jakarta.annotation.PostConstruct;

@Component
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        ProductServiceTest test = new ProductServiceTest();
        test.runTests();
    }

    @PostConstruct
    public void runTests() {
        testGetProductById();
        testGetAllProducts();
    }

    public void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();

        if (products != null && !products.isEmpty()) {
            System.out.println("✅ Lista de produtos obtida com sucesso: " + products);
        } else {
            System.err.println(" Erro: Nenhum produto foi encontrado.");
        }
    }
    
    public void testGetProductById() {
        Product product = productService.getProductById(1L);

        if (product != null) {
            System.out.println("✅ Produto encontrado: " + product);
        } else {
            System.err.println("Erro: Nenhum produto encontrado para o ID 1.");
        }
    }
}

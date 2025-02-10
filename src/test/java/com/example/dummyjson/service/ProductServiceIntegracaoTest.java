package com.example.dummyjson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.dummyjson.dto.Product;

@SpringBootApplication
public class ProductServiceIntegracaoTest implements ApplicationRunner {

    @Autowired
    private ProductService productService;

    public void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products == null || products.isEmpty()) {
            throw new RuntimeException("A lista de produtos não deve ser nula ou vazia");
        }
        System.out.println("testGetAllProducts passou!");
    }

    public void testGetProductById() {
        Long productId = 1L;
        Product product = productService.getProductById(productId);
        if (product == null || !productId.equals(product.getId())) {
            throw new RuntimeException("O produto não deve ser nulo e o ID deve corresponder ao solicitado");
        }
        System.out.println("testGetProductById passou!");
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductServiceIntegracaoTest.class)) {
        	ProductServiceIntegracaoTest test = context.getBean(ProductServiceIntegracaoTest.class);
            test.testGetAllProducts();
            test.testGetProductById();
            System.out.println("Todos os testes passaram!");
        }
    }

    @Override
    public void run(ApplicationArguments args) {
        // Método necessário para ApplicationRunner, mas não utilizado
    }
}

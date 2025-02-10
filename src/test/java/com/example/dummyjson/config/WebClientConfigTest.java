package com.example.dummyjson.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
@Component
public class WebClientConfigTest {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public void runTests() {
        testWebClientBuilderIsNotNull();
        testWebClientCanBeBuilt();
    }

    public void testWebClientBuilderIsNotNull() {
        if (webClientBuilder == null) {
            throw new RuntimeException("Erro: WebClient.Builder não foi injetado corretamente.");
        } else {
            System.out.println("✅ WebClient.Builder injetado corretamente!");
        }
    }

    public void testWebClientCanBeBuilt() {
        WebClient webClient = webClientBuilder.build();
        if (webClient == null) {
            throw new RuntimeException("Erro: WebClient não foi construído corretamente.");
        } else {
            System.out.println("✅ WebClient construído corretamente!");
        }
    }
}

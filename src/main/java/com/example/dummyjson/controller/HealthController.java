package com.example.dummyjson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public Map<String, String> checkHealth() {
        return Map.of(
            "status", "UP",
            "message", "Microsserviço rodando normalmente!",
            "javaVersion", System.getProperty("java.version")
        );
    }
}

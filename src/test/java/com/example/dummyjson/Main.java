package com.example.dummyjson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dummyjson.config.WebClientConfigTest;
import com.example.dummyjson.controller.ProductControllerTest;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
    	
    	//Setando a porta para que o main dos testes se  execute na porta 8000
    	System.setProperty("server.port", "8000");
    	 
        // Inicializa o contexto do Spring Boot
        ApplicationContext context = SpringApplication.run(Main.class, args);

        
        
        // Executa teste de  ProductControllerTest diretamente do contexto do Spring
        ProductControllerTest testController = new ProductControllerTest();
        testController.runTests();   

        // Obtém o WebClientConfigTest diretamente do contexto do Spring
        WebClientConfigTest webClientTest = context.getBean(WebClientConfigTest.class);
        webClientTest.runTests();
        
        // Encerra a aplicação com os testes de  Spring Boot
        int exitCode = SpringApplication.exit(context);
        System.exit(exitCode);
   }
}

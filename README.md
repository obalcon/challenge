
# DummyJSON Client - Java 17 e Spring Boot 3.2.5

## Descrição do Projeto

Actualização de um microsserviço Java que interage com a API pública [DummyJSON](https://dummyjson.com/docs/products) para realizar operações de busca de produtos. O projeto foi desenvolvido usando Java 17 e Spring Boot 3.2.5


## Estrutura do Projeto

```bash
dummyjson-client
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.dummyjsonclient
│   │   │       ├── DummyJsonClientApplication.java
│   │   │       ├── config
│   │   │       │   └── WebClientConfig.java
│   │   │       ├── controller
│   │   │       │   └── ProductController.java
│   │   │       │   └── HealthController.java 
│   │   │       ├── dto
│   │   │       │   └── Product.java
│   │   │       │   └── ProductResponse.java
│   │   │       ├── service
│   │   │       │   └── ProductService.java
│   │   └── resources
│   │       └── application.yaml
│   └── test
│       ├── java
│       │   └── com.example.dummyjsonclient
│       │       │   └── Main.java
│       │       ├── config
│       │       │   └── WebClientConfigTest.java
│       │       └── controller
│       │       │   └── ProductControllerTest.java
│       │       ├── dto
│       │       │   └── ProductTest.java
│       │       └── service
│       │           └── ProductServiceIntegracaoTest.java
│       │           └── ProductServiceTest.java
│       └── resources
└── pom.xml
└── Dockerfile.xml

## Passos para Executar o Projeto

### Pré-requisitos

- **Java 17
- **Maven 3.9.x**

### Executar a Aplicação

1. Compile e execute o projeto:
   
    mvn clean install
    mvn spring-boot:run
    ```

2. Acesse o serviço:

    O serviço estará disponível em `http://localhost:8080`.

### Executar Testes

	Para executar os testes unitários:

	Executar  a classe Main.java localizada no pacote com.example.dummyjson

## Docker

- Dockerfile 
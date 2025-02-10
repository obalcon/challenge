package com.example.dummyjson.dto;



import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Product.class)
public class ProductTest {

    public static void main(String[] args) {
        ProductTest test = new ProductTest();
        test.testGetAndSetter();
    }

    public void testGetAndSetter() {
        Long expectId = 1L;
        String expectedTitle = "A dummy title";
        String expectedDescription = "A dummy description";
        Double expectedPrice =  Double.valueOf("2.1");


        Product product1 = new Product();
        product1.setId(expectId);
        product1.setTitle(expectedTitle);
        product1.setDescription(expectedDescription);
        product1.setPrice(expectedPrice);

        assert expectId.equals(product1.getId()) : "ID errado";
        assert expectedTitle.equals(product1.getTitle()) : "Title errado ";
        assert expectedDescription.equals(product1.getDescription()) : "Description errada";
        assert expectedPrice.equals(product1.getPrice()) : "Price errado";

        System.out.println("Todos os testes concluidos com sucesso!");
    }
}


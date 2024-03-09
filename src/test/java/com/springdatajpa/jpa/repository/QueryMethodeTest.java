package com.springdatajpa.jpa.repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.springdatajpa.jpa.entity.Product;

@SpringBootTest
public class QueryMethodeTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethode(){

        Product product = productRepository.findByName("product 1");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void findByIdMethode(Long id){

        Product product = productRepository.findById(1L).get();

        System.out.println(product.getName());
        System.out.println(product.getDescription());
        System.out.println(product.getDateCreated());
        System.out.println(product.getPrice());

    }

    @Test
    void findByNameOrDescriptionMethode(){

        List<Product> products = productRepository.findByNameOrDescription("product 1", "product 2 description");

        products.forEach((p) -> {

            System.out.println(p.getName());
            System.out.println(p.getImageUrl());
            System.out.println(p.getPrice());

        });
    }

    @Test
    void findByNameAndDescriptionMethode(){

        List<Product> products = productRepository.findByNameAndDescription("product 1", "product 2 description");

        products.forEach((p) -> {

            System.out.println(p.getImageUrl());
            System.out.println(p.getLastUpdated());
            System.out.println(p.getDateCreated());

        });
    }

    @Test
    void findDistinctByNameMethode(){

        Product product = productRepository.findDistinctByName("product 1");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void findPriceGreaterThanMethode(){
        List<Product> products = productRepository.findPriceGreaterThan(new BigDecimal(200));

        products.forEach((p) -> {

            System.out.println(p.getPrice());
            System.out.println(p.getName());

        });
    }

    @Test
    void findPriceLessThanMethode(){

        List<Product> products = productRepository.findPriceLessThen(new BigDecimal(100));

        products.forEach((p) ->{

            System.out.println(p.getName());
            System.out.println(p.getImageUrl());

        });

    }

    @Test
    void findByNameContainingMethode(){

        List<Product> products = productRepository.findByNameContaining("product 2");

        products.forEach((p) -> {

            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findByNameLikeMethode(){

        List<Product> products = productRepository.findByNameLike("product 2");

        products.forEach((p) -> {

            System.out.println(p.getName());
            System.out.println(p.getId());

        });
    }

    @Test
    void findByPriceBetweenMethode(){

        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(200));

        products.forEach((p) ->{

            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findByDateCreatedBetweenMethode(){

        // start date
        LocalDateTime startDate = LocalDateTime.of(2024, 02, 25, 21, 55, 42.22);

        //end date

        LocalDateTime endDate = LocalDateTime.of(2024, 02, 25, 10, 11, 33);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);

        products.forEach((p) ->{

            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findByNameInMethode(){

        List<Product> products = productRepository.findByNameIn(List.of("product 1", "product 2", "product 3"));

        products.forEach((p) ->{

            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }
    
}

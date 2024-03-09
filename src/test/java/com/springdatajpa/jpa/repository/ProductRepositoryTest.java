package com.springdatajpa.jpa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpa.jpa.entity.Product;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //create product
        Product products = new Product();
        products.setName("product 1");
        products.setDescription("product 1 description");
        products.setPrice(new BigDecimal(1000));
        products.setSku("4544sdfrfth");
        products.setImageUrl("product1.png");
        products.setActive(true);

        //save product
        Product savedProduct = productRepository.save(products);

        //display project information
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());

    }

    @Test
    void updateUsingSaveMethode(){
        // find or retrieve by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 description");

        // save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethode(){
        //create product
        Product product2 = new Product();
        product2.setName("product 1");
        product2.setDescription("product 2 description");
        product2.setPrice(new BigDecimal(2000));
        product2.setSku("4544sdfrfthtghuitg");
        product2.setImageUrl("product2.png");
        product2.setActive(true);

        //create product
        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setPrice(new BigDecimal(3000));
        product3.setSku("4544sdfrfthfvfvv");
        product3.setImageUrl("product3.png");
        product3.setActive(true);

        Product product4 = new Product();
        product4.setName("product 4");
        product4.setDescription("product 4 description");
        product4.setPrice(new BigDecimal(3000));
        product4.setSku("4544sdfrftghhfvfvv");
        product4.setImageUrl("product4.png");
        product4.setActive(true);

        //save the all products
        productRepository.saveAll(List.of(product2,product3,product4));
     }

    @Test
    void findAllMethode(){
        List<Product> products = productRepository.findAll();
        products.forEach((p)->{
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod(){

        Long id = 1L;
        productRepository.deleteById(id);

    }

    @Test
    void deleteMethode(){

        //find by id 
        Long id = 5L;
        Product product = productRepository.findById(id).get();

        //Delete entity
        productRepository.delete(product);

    }

    @Test
    void deleteAllMethode(){
        productRepository.deleteAll();
    }

    @Test
    void existByIdMethod(){
        Long id = 5L;
       boolean result = productRepository.existsById(id);
       System.out.println(result);
    }
    @Test
    void countMethod(){
        Long count = productRepository.count();
        System.out.println(count);
    }
}

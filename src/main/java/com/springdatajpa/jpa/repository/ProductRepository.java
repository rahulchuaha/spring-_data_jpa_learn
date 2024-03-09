package com.springdatajpa.jpa.repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.jpa.entity.Product;
import java.time.LocalDateTime;


public interface ProductRepository extends JpaRepository<Product, Long>{

    public Product findByName(String name);

    Optional<Product> findById(Long id);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findPriceGreaterThan(BigDecimal price);

    List<Product> findPriceLessThen(BigDecimal price);

    List<Product>  findByNameContaining(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Product> findByNameIn(List<String> names);
    
}

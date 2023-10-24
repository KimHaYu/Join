package com.example.kakao.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductJPARepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from Product_tb", nativeQuery = true)
    List<Product> findByProductName();
}

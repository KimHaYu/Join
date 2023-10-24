package com.example.kakao.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartJPARepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByUserId(@Param("userId") Integer userId);
}

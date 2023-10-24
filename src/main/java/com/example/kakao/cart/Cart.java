package com.example.kakao.cart;

import lombok.*;

import javax.persistence.*;

import com.example.kakao.product.Product;
import com.example.kakao.user.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "cart_tb")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    // 상품 테이블
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    // 수량
    private Integer quantity;

    // 배송비
    private Integer deliveryFee;

    // // 예정금액
    // private Integer estimatedPrivce;

    public Cart(Integer id, Product product, Integer quantity, Integer deliveryFee) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.deliveryFee = deliveryFee;
    }

}
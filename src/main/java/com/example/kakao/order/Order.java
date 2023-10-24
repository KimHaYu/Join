package com.example.kakao.order;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.kakao.product.Product;
import com.example.kakao.user.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "order_tb")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 판매자 이름
    private String sellerName;

    // 상품 테이블

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    // 수량
    private Integer quantity;

    // 배송비
    private Integer deliveryFee;

    // 결재 금액
    private Integer approvalPrice;

    public Order(Integer id, String sellerName, Product product, Integer quantity, Integer deliveryFee,
            Integer approvalPrice) {
        this.id = id;
        this.sellerName = sellerName;
        this.product = product;
        this.quantity = quantity;
        this.deliveryFee = deliveryFee;
        this.approvalPrice = approvalPrice;
    }

}

package com.example.kakao.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "product_tb")
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    // 썸네일
    @Column(length = 500)
    private String thumbnail;
    // 판매자 이름
    @Column(length = 100, nullable = false)
    private String seller;
    // 상품 타이틀
    @Column(length = 100, nullable = false)
    private String productTitle;
    @Column(length = 500)
    // 할인전 가격
    private Integer price;
    // 할인율
    private Integer discountRate;

    @Builder
    public Product(Integer id, String thumbnail, String seller, String productTitle, Integer price,
            Integer discountRate) {
        Id = id;
        this.thumbnail = thumbnail;
        this.seller = seller;
        this.productTitle = productTitle;
        this.price = price;
        this.discountRate = discountRate;
    }

}

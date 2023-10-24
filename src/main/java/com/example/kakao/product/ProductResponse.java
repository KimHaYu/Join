package com.example.kakao.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ProductResponse {
    // 상품 목록보기
    @ToString
    @Getter
    @Setter
    public static class ProductDTO {
        private Integer Id;
        private String thumbnail;
        private String seller;
        private String productTitle;
        private Integer price;
        private Integer discountRate;
        private Integer totalPrice;

        public ProductDTO(Product product) {
            this.Id = product.getId();
            this.thumbnail = product.getThumbnail();
            this.seller = product.getSeller();
            this.productTitle = product.getProductTitle();
            this.price = product.getPrice();
            this.discountRate = product.getDiscountRate();
            this.totalPrice = product.getPrice() * (100 - product.getDiscountRate()) / 100;
        }
    }

}
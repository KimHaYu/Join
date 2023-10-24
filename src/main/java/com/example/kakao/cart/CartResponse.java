package com.example.kakao.cart;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.kakao.product.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CartResponse {

    @ToString
    @Getter
    @Setter
    public static class FindAllDTO {

        private List<CartProductDTO> cartProducts;
        private Integer totalBeforePrice;
        private Integer totalDiscountPrice;
        private Integer deliveryFee;
        private Integer totalPrice;

        public FindAllDTO(List<Cart> carts) {
            this.cartProducts = carts.stream()
                    .map(o -> new CartProductDTO(o.getProduct(), o))
                    .collect(Collectors.toList());
            this.totalBeforePrice = carts.stream().mapToInt(o -> o.getProduct().getPrice() * o.getQuantity())
                    .sum();
            this.totalDiscountPrice = carts.stream()
                    .mapToInt(o -> (o.getProduct().getPrice() * (o.getProduct().getDiscountRate()) / 100)
                            * o.getQuantity())
                    .sum();
            this.totalPrice = totalBeforePrice - totalDiscountPrice;
            if (totalBeforePrice - totalDiscountPrice > 20000) {

                this.deliveryFee = 0;
            } else {
                this.deliveryFee = 3500;
            }
        }

        @Getter
        @Setter
        class CartProductDTO {
            private Integer id;
            private String productTitle;
            private String productSeller;
            private String image;
            private Integer beforeDiscount;
            private Integer discountedPrice;
            private Integer quentity;

            public CartProductDTO(Product product, Cart cart) {
                id = product.getId();
                productTitle = product.getProductTitle();
                productSeller = product.getSeller();
                image = product.getThumbnail();
                beforeDiscount = product.getPrice();
                discountedPrice = product.getPrice() * (100 - product.getDiscountRate()) / 100;
                this.quentity = cart.getQuantity();
            }
        }
    }
}

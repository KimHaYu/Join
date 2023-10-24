package com.example.kakao.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakao._core.utils.ApiUtils;
import com.example.kakao.cart.CartResponse.FindAllDTO;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CartRestController {

    @Autowired
    CartService cartService;

    @GetMapping("/api/carts")
    public ResponseEntity<?> findById() {

        List<Cart> carts = cartService.장바구니조회(1);
        CartResponse.FindAllDTO findAllDTO = new CartResponse.FindAllDTO(carts);
        return ResponseEntity.ok(ApiUtils.success(findAllDTO));
    }

}

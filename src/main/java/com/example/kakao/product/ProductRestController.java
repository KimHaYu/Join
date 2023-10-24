package com.example.kakao.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.kakao._core.utils.ApiUtils;
import com.example.kakao.product.ProductResponse.ProductDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService;

    // 상품 목록보기
    @GetMapping("/api/products")
    public List<ProductDTO> 상품페이지() {
        List<ProductDTO> products = productService.상품전체조회v2();
        return products;
    }

}
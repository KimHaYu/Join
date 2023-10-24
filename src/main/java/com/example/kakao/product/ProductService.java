package com.example.kakao.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakao.product.ProductResponse.ProductDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductService {
    @Autowired
    private ProductJPARepository productJPARepository;

    // (기능1) 상품 목록보기
    public List<Product> 상품전체조회() {

        List<Product> products = productJPARepository.findAll();

        return products;

    }

    // (기능1) 상품 목록보기
    public List<ProductDTO> 상품전체조회v2() {

        List<Product> products = productJPARepository.findByProductName();
        List<ProductDTO> productDtos = products.stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());

        return productDtos;

    }


}
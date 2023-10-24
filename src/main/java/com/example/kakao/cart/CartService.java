package com.example.kakao.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CartService {

    @Autowired
    CartJPARepository cartJPARepository;

    public List<Cart> 장바구니조회(Integer id) {
        List<Cart> carts = cartJPARepository.findByUserId(id);

        return carts;
    }
}

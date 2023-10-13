package com.study.jiyunboard.service;

import com.study.jiyunboard.entity.Cart;
import com.study.jiyunboard.entity.Goods;
import com.study.jiyunboard.entity.Member;
import com.study.jiyunboard.repository.CartRepository;
import com.study.jiyunboard.request.CartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    // 장바구니 담기.
    public void addCart(CartRequest cartRequest) {
        Member member = cartRequest.getMember();
        Goods goods = cartRequest.getGoods();
        int count = cartRequest.getCount();

        Cart savedCart = cartRepository.findByMemberAndGoods(member, goods);
        if (savedCart != null) {
            savedCart.addCart(count);
            cartRepository.save(savedCart);
        } else {
            Cart targetCart = Cart.createCart(count, goods, member);
            cartRepository.save(targetCart);
        }
    }

}

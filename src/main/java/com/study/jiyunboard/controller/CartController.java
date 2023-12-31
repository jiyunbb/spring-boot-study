package com.study.jiyunboard.controller;

import com.study.jiyunboard.entity.Cart;
import com.study.jiyunboard.request.CartRequest;
import com.study.jiyunboard.response.BaseResponse;
import com.study.jiyunboard.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/members/{id}/carts")
    public ResponseEntity<List<Cart>> getCartList(@PathVariable Integer id) {
        return new ResponseEntity<>(cartService.getCartList(id), HttpStatus.OK);
    }

    @PostMapping("/members/{id}/carts")
    public ResponseEntity<BaseResponse> addCart(@PathVariable Integer id, @RequestBody CartRequest cartRequest) {
        cartService.addCart(id, cartRequest);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("장바구니가 담겼습니다.");
        baseResponse.setCode("1000");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}

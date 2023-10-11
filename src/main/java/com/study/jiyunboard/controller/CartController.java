package com.study.jiyunboard.controller;

import com.study.jiyunboard.request.CartRequestData;
import com.study.jiyunboard.response.BaseResponse;
import com.study.jiyunboard.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/carts")
    @ResponseBody
    public ResponseEntity<BaseResponse> addCart(@RequestBody CartRequestData cartRequestData) {
        cartService.addCart(cartRequestData);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("장바구니가 담겼습니다.");
        baseResponse.setCode("1000");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}

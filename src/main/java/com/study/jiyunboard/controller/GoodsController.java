package com.study.jiyunboard.controller;

import com.study.jiyunboard.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @GetMapping("/goods")
    public ResponseEntity<?> getGoods(@RequestParam(required = false) Integer id) {
        if (id != null) {
            return new ResponseEntity<>(goodsService.goodsView(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(goodsService.goodsList(), HttpStatus.OK);
        }
    }

    // TODO 이후에 주문로직으로 합쳐지도록 수정이 필요하다. - 낙관적인 락 테스트, 다만 분산락을 redisson을 이용하여 동시성 이슈 해결해보면 좋을 듯!
    @GetMapping("/goods/{id}/decrease-stock")
    public void decreaseStockCount(@PathVariable Integer id){
        goodsService.decreaseStockCount(id);
    }

}

package com.study.jiyunboard.controller;

import com.study.jiyunboard.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

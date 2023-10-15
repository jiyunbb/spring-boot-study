package com.study.jiyunboard.controller;

import com.study.jiyunboard.entity.ShippingInfo;
import com.study.jiyunboard.request.ShippingInfoRequest;
import com.study.jiyunboard.response.BaseResponse;
import com.study.jiyunboard.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ShippingController {
    @Autowired
    AddressService addressService;

    @GetMapping("/members/{id}/address")
    public ResponseEntity<List<ShippingInfo>> shippingInfoList(@PathVariable Integer id) {
        return new ResponseEntity<>(addressService.shippingInfoList(id), HttpStatus.OK);
    }

    @PostMapping("/members/{id}/address")
    public ResponseEntity<BaseResponse> addShippingInfo(@PathVariable Integer id, @RequestBody ShippingInfoRequest shippingInfoRequest) {
        addressService.addShippingInfo(id, shippingInfoRequest);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("주소지 입력 성공.");
        baseResponse.setCode("1000");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}

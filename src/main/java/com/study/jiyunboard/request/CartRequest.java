package com.study.jiyunboard.request;

import com.study.jiyunboard.entity.Goods;
import lombok.Data;

@Data
public class CartRequest {
    private Goods goods;
    private int count;
}

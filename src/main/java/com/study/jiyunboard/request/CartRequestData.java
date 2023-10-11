package com.study.jiyunboard.request;

import com.study.jiyunboard.entity.Goods;
import com.study.jiyunboard.entity.Member;
import lombok.Data;

@Data
public class CartRequestData {
    private Goods goods;
    private Member member;
    private int count;
}

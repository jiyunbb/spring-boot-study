package com.study.jiyunboard.service;

import com.study.jiyunboard.entity.Goods;
import com.study.jiyunboard.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    public List<Goods> goodsList() {
        return goodsRepository.findAll();
    }

    public Goods goodsView(Integer id) {
        return goodsRepository.findById(id).get();
    }
}

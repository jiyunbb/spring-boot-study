package com.study.jiyunboard.service;

import com.study.jiyunboard.entity.Goods;
import com.study.jiyunboard.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    // TODO 재고 처리 관련 낙관적인 락 테스트 -> 이후 주문 로직 개발되면 그쪽으로 옮기기.
    public void decreaseStockCount(Integer id) {
        /*
         * 낙관적 락(Optimistic Lock)
         * 충돌이 발생하지 않을 것이라 가정하고 Lock을 거는 방식
         * 트랜잭션을 commit 하는 시점에 충돌을 알 수 있음
         * DB Level 에서 동시성을 처리하는것이 아닌 Application Level 에서 처리
         *
         * 비관적 락(Pessimistic Lock)
         * 충돌이 발생할것이라 가정하고 우선 DB에 Lock을 거는 방식 (select for update)
         * 데이터를 수정하는 즉시 충돌을 알 수 있음
         * DB Level 동시성을 처리
         *
         * 전 회사에서 커머스 기능 사용 시 select_for_update 라는 장고 orm 내 함수를 이용했었음. -> 비관적인 락.
         * 낙관적인 접근은 하지 않았음.
         * */
        Goods goods = goodsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        goods.decreaseStockCount(1);
        goodsRepository.save(goods);
    }
}

package com.study.jiyunboard.repository;

import com.study.jiyunboard.entity.Cart;
import com.study.jiyunboard.entity.Goods;
import com.study.jiyunboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("SELECT c FROM Cart c WHERE c.member = :member AND c.goods = :goods")
    Cart findByMemberAndGoods(@Param("member") Member member, @Param("goods") Goods goods);

    @Query("SELECT c FROM Cart c WHERE c.member = :member")
    List<Cart> findByMember(@Param("member") Member member);
}

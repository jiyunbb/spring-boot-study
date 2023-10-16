package com.study.jiyunboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQ")
    @SequenceGenerator(sequenceName = "cart_seq", allocationSize = 1, name = "CART_SEQ")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonIgnore
    private Member member;

    @ManyToOne
    @JoinColumn(name = "GOODS_ID")
    private Goods goods;

    private Integer count;

    public static Cart createCart(int count, Goods goods, Member member) {
        Cart cart = new Cart();
        cart.setGoods(goods);
        cart.setMember(member);
        cart.setCount(count);
        return cart;
    }

    public void addCart(int count) {
        this.count += count;
    }
}

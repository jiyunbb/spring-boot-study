package com.study.jiyunboard.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GOODS_SEQ")
    @SequenceGenerator(sequenceName = "goods_seq", allocationSize = 1, name = "GOODS_SEQ")
    private Integer id;
    private Integer version;
    private String name;
    private Integer customerPrice;
    private Integer productPrice;
    private Integer discountRate;
}

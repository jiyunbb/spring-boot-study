package com.study.jiyunboard.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer version;
    private String name;
    private Integer customerPrice;
    private Integer productPrice;
    private Integer discountRate;
}

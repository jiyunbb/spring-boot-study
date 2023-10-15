package com.study.jiyunboard.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
    @SequenceGenerator(sequenceName = "member_seq", allocationSize = 1, name = "MEMBER_SEQ")
    private Integer id;

    private String name;
    private String phone;
}

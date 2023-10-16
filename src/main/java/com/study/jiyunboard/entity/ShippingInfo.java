package com.study.jiyunboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SHIPPINGINFO")
public class ShippingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIPPINGINFO_SEQ")
    @SequenceGenerator(sequenceName = "shippinginfo_seq", allocationSize = 1, name = "SHIPPINGINFO_SEQ")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonIgnore
    private Member member;

    private String defaultAddress;
    private String detailAddress;
    private String shippingName;
    private String shippingPhone;
    private String zipcode;
    private int isDefault;

    public static ShippingInfo createShippingInfo(Member member, String defaultAddress, String detailAddress, String shippingName, String shippingPhone, String zipcode, int isDefault) {
        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo.setMember(member);
        shippingInfo.setDefaultAddress(defaultAddress);
        shippingInfo.setDetailAddress(detailAddress);
        shippingInfo.setShippingName(shippingName);
        shippingInfo.setShippingPhone(shippingPhone);
        shippingInfo.setZipcode(zipcode);
        shippingInfo.setIsDefault(isDefault);
        return shippingInfo;
    }
}

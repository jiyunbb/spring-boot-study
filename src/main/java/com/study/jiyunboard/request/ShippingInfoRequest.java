package com.study.jiyunboard.request;

import lombok.Data;

@Data
public class ShippingInfoRequest {
    private String defaultAddress;
    private String detailAddress;
    private String shippingName;
    private String shippingPhone;
    private String zipcode;
    private boolean isDefault;
}

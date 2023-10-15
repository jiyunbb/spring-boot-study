package com.study.jiyunboard.service;

import com.study.jiyunboard.entity.Member;
import com.study.jiyunboard.entity.ShippingInfo;
import com.study.jiyunboard.repository.AddressRepository;
import com.study.jiyunboard.repository.MemberRepository;
import com.study.jiyunboard.request.ShippingInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    MemberRepository memberRepository;

    public void addShippingInfo(Integer userId, ShippingInfoRequest shippingInfoRequest) {
        Optional<Member> targetMember = memberRepository.findById(userId);
        targetMember.ifPresent(member -> {
            // targetMember가 존재하는 경우의 로직
            ShippingInfo targetShippingInfo = ShippingInfo.createShippingInfo(
                    member,
                    shippingInfoRequest.getDefaultAddress(),
                    shippingInfoRequest.getDetailAddress(),
                    shippingInfoRequest.getShippingName(),
                    shippingInfoRequest.getShippingPhone(),
                    shippingInfoRequest.getZipcode(),
                    shippingInfoRequest.getIsDefault()
            );
            addressRepository.save(targetShippingInfo);
        });
    }

    public List<ShippingInfo> shippingInfoList(Integer userId) {
//        Optional<Member> targetMember = memberRepository.findById(userId);
        return addressRepository.findShippingInfoByUserId(userId);
    }
}

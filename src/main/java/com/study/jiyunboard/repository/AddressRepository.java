package com.study.jiyunboard.repository;

import com.study.jiyunboard.entity.Member;
import com.study.jiyunboard.entity.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<ShippingInfo, Integer> {
    @Query("SELECT s FROM ShippingInfo s WHERE s.member.id = :userId")
    List<ShippingInfo> findShippingInfoByUserId(@Param("userId") Integer userId);
}

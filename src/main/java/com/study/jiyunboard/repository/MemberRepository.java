package com.study.jiyunboard.repository;

import com.study.jiyunboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByPhone(String phone);

}

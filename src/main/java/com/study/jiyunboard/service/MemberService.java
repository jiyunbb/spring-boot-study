package com.study.jiyunboard.service;

import com.study.jiyunboard.entity.Member;
import com.study.jiyunboard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void signUp(Member member) {
        memberRepository.save(member);
    }

    public void signIn(Member member) {
        memberRepository.findByPhone(member.getPhone());
    }

    public List<Member> memberList() {
        return memberRepository.findAll();
    }

    public void deleteMember(Integer id) {
        memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        memberRepository.deleteById(id);
    }
}

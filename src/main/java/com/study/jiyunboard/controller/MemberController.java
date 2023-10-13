package com.study.jiyunboard.controller;

import com.study.jiyunboard.entity.Member;
import com.study.jiyunboard.response.BaseResponse;
import com.study.jiyunboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<BaseResponse> singUp(@RequestBody Member member) {
        memberService.signUp(member);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("회원가입 성공 성공.");
        baseResponse.setCode("1000");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<BaseResponse> signIn(@RequestBody Member member) {
        memberService.signIn(member);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("로그인 성공.");
        baseResponse.setCode("1000");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> memberList() {
        return new ResponseEntity<>( memberService.memberList(), HttpStatus.OK);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<BaseResponse> deleteMember(@PathVariable Integer id) {
        memberService.deleteMember(id);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("멤버 삭제 성공.");
        baseResponse.setCode("1000");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/members/{id}/address")
    public ResponseEntity<BaseResponse> addAddress(@PathVariable Integer id,  @RequestBody AddressRequest addressRequest) {
        memberService.addAddress(id, addressReques);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("주소 입력 성공.");
        baseResponse.setCode("1000");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}

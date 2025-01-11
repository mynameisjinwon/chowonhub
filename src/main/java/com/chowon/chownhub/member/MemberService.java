package com.chowon.chownhub.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberService {
    private static Logger log = LoggerFactory.getLogger(MemberService.class);

    private MemberRepository memberRepository;

    public void join(Member member) {
        Member dbMember = memberRepository.findById(member.getMemberId());
        // 이미 존재하는 회원
        if (dbMember != null) {
            log.debug("이미 존재하는 회원 아이디!");
            return;
        }
        memberRepository.save(member);
    }

    // 회원 아이디 찾기
    public String findId(String email) {
        return memberRepository.findId(email);
    }

    // 회원 비밀번호 찾기
    public String findPw(String email) {
        return memberRepository.findPw(email);
    }
}

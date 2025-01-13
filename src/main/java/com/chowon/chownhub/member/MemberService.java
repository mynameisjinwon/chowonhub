package com.chowon.chownhub.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        Member dbMember = memberRepository.findById(member.getMemberId());
        // 이미 존재하는 회원
        if (dbMember != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        memberRepository.save(member);
    }

    public boolean login(Member member) {
        Member dbMember = memberRepository.findById(member.getMemberId());
        // 존재하지 않는 회원
        if (dbMember == null) {
            return false;
        }
        // 잘못된 비밀번호를 입력하면
        return dbMember.getPassword().equals(member.getPassword());
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

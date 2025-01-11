package com.chowon.chownhub.member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);

    void update(Member member);

    void delete(String memberId);

    Member findById(String memberId);

    String findId(String email);

    String findPw(String email);

    List<Member> findAll();
}

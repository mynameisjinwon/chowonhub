package com.chowon.chownhub.member;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MemoryMemberRepositoryTest {

    MemberRepository repo = new MemoryMemberRepository();

    @Test
    public void 아이디찾기() {
        Member member = new Member("jinwon", "1234", "jinwon", "jinwon599@gmail.com");

        repo.save(member);

        String id = repo.findId(member.getEmail());
        assertThat(member.getMemberId()).isEqualTo(id);
    }

    @Test
    public void 비번찾기() {
        Member member = new Member("jinwon", "1234", "jinwon", "jinwon599@gmail.com");

        repo.save(member);

        String pw = repo.findPw(member.getEmail());
        assertThat(member.getPassword()).isEqualTo(pw);
    }

    @Test
    public void 아이디찾기실패() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> repo.findId("hehe"));
        assertThat(e.getMessage()).isEqualTo("등록되지 않은 이메일입니다.");
    }

    @Test
    public void 비번찾기실패() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> repo.findPw("hehe"));
        assertThat(e.getMessage()).isEqualTo("등록되지 않은 이메일입니다.");
    }

    @Test
    public void 아이디로검색() {
        Member id = repo.findById("없는아이디");

        assertThat(id).isEqualTo(null);
    }
}
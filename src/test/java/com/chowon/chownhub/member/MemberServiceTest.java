package com.chowon.chownhub.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {

    private MemberService service;
    private MemoryMemberRepository repo;

    @BeforeEach
    public void init() {
        repo = new MemoryMemberRepository();
        service = new MemberService(repo);
    }

    @AfterEach
    public void after() {
        repo.clear();
    }
    @Test
    public void 회원가입테스트() {
        Member newMember = new Member("jinwon599", "1234", "jinwon", "jiwnon599@gmail.com");

        MemberService service = new MemberService(new MemoryMemberRepository());

        service.join(newMember);

        Member dbmember = repo.findById(newMember.getMemberId());

        assertThat(newMember).isEqualTo(dbmember);
    }
    @Test
    public void 로그인테스트() {
        Member newMember = new Member("jinwon599", "1234", "jinwon", "jiwnon599@gmail.com");
        service.join(newMember);

        boolean login = service.login(newMember);
        assertThat(login).isEqualTo(true);

    }
    @Test
    public void 로그인실패() {
        Member newMember = new Member("jinwon599", "1234", "jinwon", "jiwnon599@gmail.com");
        service.join(newMember);

        boolean login1 = service.login(new Member("jinwon599", "123", null, null));
        assertThat(login1).isEqualTo(false);

        boolean login = service.login(new Member("j", "1", "1", "1"));
        assertThat(login).isEqualTo(false);


    }
    @Test
    public void 중복회원테스트() {
        Member newMember = new Member("jinwon599", "1234", "jinwon", "jiwnon599@gmail.com");
        Member newMember2 = new Member("jinwon599", "1234", "jinwon", "jiwnon599@gmail.com");

        service.join(newMember);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> service.join(newMember2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    public void 아이디찾기() {
        Member newMember = new Member("jinwon599", "1234", "jinwon", "jiwnon599@gmail.com");

        service.join(newMember);

        String id = service.findId(newMember.getEmail());
        assertThat(newMember.getMemberId()).isEqualTo(id);
    }

    @Test
    public void 비번찾기() {
        Member newMember = new Member("jinwon599", "1234", "jinwon", "jiwnon599@gmail.com");

        service.join(newMember);

        String pw = service.findPw(newMember.getEmail());
        assertThat(newMember.getPassword()).isEqualTo(pw);
    }


}
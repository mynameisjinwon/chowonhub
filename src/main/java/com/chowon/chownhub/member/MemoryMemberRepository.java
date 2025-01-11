package com.chowon.chownhub.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryMemberRepository implements MemberRepository{
    private static final Map<String, Member> members = new HashMap<>();

    @Override
    public void save(Member member) {
        members.put(member.getMemberId(), member);
    }

    @Override
    public void update(Member member) {
        members.put(member.getMemberId(), member);
    }

    @Override
    public void delete(String memberId) {
        members.put(memberId, null);
    }

    @Override
    public Member findById(String memberId) {
        return members.get(memberId);
    }

    @Override
    public String findId(String email) {
        String missingId = null;
        List<Member> allMember = findAll();
        for (Member m : allMember) {
            if (m.getEmail().equals(email)) {
                missingId = m.getMemberId();
                break;
            }
        }
        return missingId;
    }

    @Override
    public String findPw(String email) {
        String missingPw = null;
        List<Member> allMember = findAll();
        for (Member m : allMember) {
            if (m.getEmail().equals(email)) {
                missingPw = m.getPassword();
                break;
            }
        }
        return missingPw;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members.values());
    }
}

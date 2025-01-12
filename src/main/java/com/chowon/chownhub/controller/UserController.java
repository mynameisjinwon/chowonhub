package com.chowon.chownhub.controller;

import com.chowon.chownhub.member.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    // 로그인 화면 출력
    @GetMapping("/user/login")
    public String showLogin() {
        System.out.println("xxxsexxxx");
        log.debug("showLogin() 메소드 호출");
        return "/user/login.html";
    }

    // 로그인 기능 구현
    @PostMapping("/user/login")
    public String userLogin(Member member) {
        System.out.println("userLogin 호출");
        log.debug("*****************login member : {}", member);
        return "redirect:/";
    }

    // 회원가입 화면 출력
    @GetMapping("/user/join")
    public String showFrom() {

        return "/user/form.html";
    }

    @PostMapping("/user/join")
    public String createUser(Member member) {
        log.debug("new member : {}", member);
        return "redirect:/";
    }
}

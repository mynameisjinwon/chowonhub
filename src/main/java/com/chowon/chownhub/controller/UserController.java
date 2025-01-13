package com.chowon.chownhub.controller;

import com.chowon.chownhub.member.Member;
import com.chowon.chownhub.member.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.http.HttpResponse;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private MemberService service;

    public UserController(MemberService service) {
        this.service = service;
    }

    // 로그인 화면 출력
    @GetMapping("/user/login")
    public String showLogin() {
        return "/user/login.html";
    }

    // 로그인 기능 구현
    @PostMapping("/user/login")
    public String userLogin(Member member, HttpServletRequest request, Model model) {
        if (!service.login(member)) {
            log.debug("로그인 실패 : {}", member);
            return "redirect:/user/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", member);
        model.addAttribute(member);
        log.debug("로그인 성공 : {}", member.getMemberId());
        return "redirect:/";
    }

    // 로그아웃
    @GetMapping("/user/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

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
        service.join(member);
        return "redirect:/";
    }
}

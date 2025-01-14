package com.chowon.chownhub.controller;

import com.chowon.chownhub.member.Member;
import com.chowon.chownhub.session.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
    @GetMapping("/")
    public String showIndex(HttpServletRequest request, Model model) {
        // 세션을 통해 사용자가 로그인 했는지 확인하고 모델에 로그인한 회원 정보를 담는다.
        SessionManager manager = new SessionManager(request, model);
        manager.loginCheck();

        return "/index.html";
    }
}

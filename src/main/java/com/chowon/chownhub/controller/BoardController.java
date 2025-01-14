package com.chowon.chownhub.controller;

import com.chowon.chownhub.session.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    private static final Logger log = LoggerFactory.getLogger(BoardController.class);
    // 공지사항 출력
    @GetMapping("/board/notice")
    public String showNotice(HttpServletRequest request, Model model) {
        SessionManager manager = new SessionManager(request, model);
        manager.loginCheck();
        log.debug("showNotice 메소드 호출됨");
        return "/board/board_notice.html";
    }

    // 거래처 스펙 출력
    @GetMapping("/board/specs")
    public String showSpecs(HttpServletRequest request, Model model) {
        SessionManager manager = new SessionManager(request, model);
        manager.loginCheck();
        return "/board/board_specs.html";
    }

    // 마음의 소리 출력
    @GetMapping("/board/heart")
    public String showHeart(HttpServletRequest request, Model model) {
        SessionManager manager = new SessionManager(request, model);
        manager.loginCheck();
        return "/board/board_heart.html";
    }
}

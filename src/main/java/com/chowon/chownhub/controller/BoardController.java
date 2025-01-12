package com.chowon.chownhub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    private static final Logger log = LoggerFactory.getLogger(BoardController.class);
    // 공지사항 출력
    @GetMapping("/board/notice")
    public String showNotice() {
        log.debug("showNotice 메소드 호출됨");
        return "/board/board_notice.html";
    }

    // 거래처 스펙 출력
    @GetMapping("/board/specs")
    public String showSpecs() {
        return "/board/board_specs.html";
    }

    // 마음의 소리 출력
    @GetMapping("/board/heart")
    public String showHeart() {
        return "/board/board_heart.html";
    }
}

package com.chowon.chownhub.controller;

import com.chowon.chownhub.board.Board;
import com.chowon.chownhub.board.BoardService;
import com.chowon.chownhub.board.BoardSubject;
import com.chowon.chownhub.session.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private static final Logger log = LoggerFactory.getLogger(BoardController.class);
    private BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    // enum 값 넘겨주기
    @ModelAttribute("boardSubjects")
    public BoardSubject[] boardSubjects() {
        return BoardSubject.values();
    }

    // 공지사항 출력
    @GetMapping("/board/notice")
    public String showNotice(HttpServletRequest request, Model model) {

        SessionManager manager = new SessionManager(request, model);
        manager.loginCheck();
        model.addAttribute("subject", "notice");
        log.debug("showNotice 메소드 호출됨");
        return "/board/board_notice.html";
    }

    // 거래처 스펙 출력
    @GetMapping("/board/specs")
    public String showSpecs(HttpServletRequest request, Model model) {
        SessionManager manager = new SessionManager(request, model);
        manager.loginCheck();
        model.addAttribute("subject", "specs");
        return "/board/board_specs.html";
    }

    // 마음의 소리 출력
    @GetMapping("/board/heart")
    public String showHeart(HttpServletRequest request, Model model) {
        SessionManager manager = new SessionManager(request, model);
        manager.loginCheck();
        model.addAttribute("subject", "heart");
        return "/board/board_heart.html";
    }

    // 글쓰기 출력
    @GetMapping("/board/create")
    public String showBoardForm(HttpServletRequest request, Model model) {
        SessionManager manager = new SessionManager(request, model);
        manager.loginCheck();

        String subject = request.getParameter("subject");
        log.debug("subject : {}", subject);

        model.addAttribute("subject", subject);
        return "/board/board_form.html";
    }
    @PostMapping("/board/create")
    public String createBoard(Board board, HttpServletRequest request, Model model) {
        SessionManager manager = new SessionManager(request, model);
        manager.loginCheck();

        log.debug("new board : {}", board);
        service.createBoard(board);
        return "redirect:/board/" + board.getSubject().getSubjectName();
    }
}

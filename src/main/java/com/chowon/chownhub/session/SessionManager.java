package com.chowon.chownhub.session;

import com.chowon.chownhub.member.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.ui.Model;

/**
 * session 이 존재하면 세션값을 불러와 view 페이지로 뿌려주는 클래스
 */
public class SessionManager {

    private final HttpServletRequest request;
    private final Model model;
    private final String sessionKey = "loginMember";

    public SessionManager(HttpServletRequest request, Model model) {
        this.request = request;
        this.model = model;
    }

    public void loginCheck() {
        HttpSession session = request.getSession();
        Member loginMember = (Member) session.getAttribute(sessionKey);
        if (loginMember == null) {
            return;
        }
        model.addAttribute("member", loginMember);
    }

}

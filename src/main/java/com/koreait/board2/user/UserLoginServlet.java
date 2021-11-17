package com.koreait.board2.user;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //로그인 창 띄우는 담당
        MyUtils.disForward(req, res, "user/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //로그인 버튼 눌렀을때 처리 담당, uid, upw 받아야함
        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");

        UserVO param = new UserVO();

        param.setUid(uid);
        param.setUpw(upw);

        //0 : 로그인실패, 1:로그인성공, 2: 아이디없음, 3: 비번틀림
        int result = UserDAO.login(param);

        if (result ==1) {
            //세션 로그인 처리
            param.setUpw(null);//비밀번호값 지우기, 용량 차지 안하게

            HttpSession session = req.getSession();
            session.setAttribute("loginUser", param);
            //iuser, nm, uid

            res.sendRedirect("/board/list");
            return;
        }
        String err = null;
        switch (result) {
            case 0:
                err = "로그인에 실패하였습니다.";
                break;
            case 2:
                err = "아이디를 확인해 주세요.";
                break;
            case 3:
                err = "비밀번호를 확인해 주세요.";
                break;
        }
        req.setAttribute("err", err);
        doGet(req, res); //로그인 페이지로 이동
    }
}

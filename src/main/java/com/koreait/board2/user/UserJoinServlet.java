package com.koreait.board2.user;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MyUtils.disForward(req, res, "user/join");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");
        String nm = req.getParameter("nm");
        int gender = MyUtils.getParameterInt(req, "gender");

        System.out.println("uid : " + uid);
        System.out.println("upw : " + upw);
        System.out.println("nm : " + nm);
        System.out.println("gender : " + gender);


        UserVO parma = new UserVO();
        parma.setUid(uid);
        parma.setUpw(upw);
        parma.setNm(nm);
        parma.setGender(gender);

        int result = UserDAO.join(parma);

        switch (result) {
            case 1:
                res.sendRedirect("/user/login");
                break;
            default:
//                //첫번째 방법
//                res.sendRedirect("/user/join");
//                break;
                //두번째 방법
                req.setAttribute("msg", "회원가입에 실패하였습니다.");
                doGet(req, res);
                break;
        }



    }
}

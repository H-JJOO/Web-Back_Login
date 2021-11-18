//package com.koreait.board2.board;
//
//import com.koreait.board2.MyUtils;
//import com.koreait.board2.model.BoardVO;
//import com.koreait.board2.model.UserVO;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet("/board/mod")
//public class BoardModServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        int iboard = MyUtils.getParameterInt(req, "iboard");
//        BoardVO param = new BoardVO();
//
//        param.setIboard(iboard);
//
//        BoardVO data = BoardDAO.selBoardDetail(param);
//
//        req.setAttribute("data", data);
//
//        MyUtils.disForward(req, res, "board/mod");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        int iboard = MyUtils.getParameterInt(req, "iboard");
//        String title = req.getParameter("title");
//        String ctnt = req.getParameter("ctnt");
//
//        HttpSession session = req.getSession();
//        UserVO loginUser = (UserVO)session.getAttribute("loginUser");
//
//        BoardVO param = new BoardVO();
//
//        param.setIboard(iboard);
//        param.setTitle(title);
//        param.setCtnt(ctnt);
//        param.setWriter(loginUser.getIuser());
//
//        int result = BoardDAO.insBoard(param);
//
//        switch (result) {
//            case 1:
//                res.sendRedirect("/board/list");
//                break;
//            case 0:
//                req.setAttribute("err", "글 수정에 실패하였습니다.");
//                doGet(req, res);
//                break;
//        }
//    }
//}

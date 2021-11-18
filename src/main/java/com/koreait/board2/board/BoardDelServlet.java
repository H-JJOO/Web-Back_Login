package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardVO;
import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/del")
public class BoardDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");

        if (loginUser == null) {
//            res.sendRedirect("/board/detail?err=1");
            req.setAttribute("err", "로그인 해주세요.");
            //같은 Get 방식이기때문에 가능
            req.getRequestDispatcher("/board/detail").forward(req, res);
            return;
        }

        int iboard = MyUtils.getParameterInt(req, "iboard");

        BoardVO param = new BoardVO();

        param.setIboard(iboard);
        param.setWriter(loginUser.getIuser());

        int result = BoardDAO.delBoard(param);

        if (result == 0) {
            req.setAttribute("err", "로그인 사용자가 작성한 글이 아닙니다.");
            //같은 Get 방식이기때문에 가능
            req.getRequestDispatcher("/board/detail").forward(req, res);
            return;
        }



        switch (result) {
            case 1:
                res.sendRedirect("/board/list");
                break;
            case 0:
                req.setAttribute("err", "글 삭제를 실패하였습니다.");
                doGet(req, res);
                break;
        }
    }
}

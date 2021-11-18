<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserVO loginUser = (UserVO)session.getAttribute("loginUser");
    BoardVO vo = (BoardVO)request.getAttribute("data");
    int prevIboard = (int)request.getAttribute("prevIboard");
    int nextIboard = (int)request.getAttribute("nextIboard");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${data.title}</title>
</head>
<body>
    <h1>디테일</h1>

    <div>
        <%if (loginUser != null && vo.getWriter() == loginUser.getIuser()) { %>
        <a href="/board/del?iboard=${data.iboard}"><input type="button" value="삭제"></a>
        <a href="/board/mod?iboard=${data.iboard}"><input type="button" value="수정"></a>
        <% } %>
        <div>${requestScope.err}</div>
        <a href="/board/list"><input type="button" value="리스트"></a>
    </div>

    <div>
        번호 : ${data.iboard}
    </div>
    <div>
        제목 : ${data.title}
    </div>
    <div>
        작성자 : ${data.writerNm}
    </div>
    <div>
        작성일자 : ${data.rdt}
    </div>
    <div>
        내용 : ${data.ctnt}
    </div>

    <div>
        <% if (prevIboard != 0 ) { %>
        <a href="detail?iboard=<%=prevIboard%>"><input type="button" value="이전글"></a>
        <% } %>
        <% if (nextIboard != 0 ) { %>
        <a href="detail?iboard=<%=nextIboard%>"><input type="button" value="다음글"></a>
        <% } %>
    </div>

</body>
</html>

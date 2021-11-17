<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserVO loginUser = (UserVO)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리스트</title>
</head>
<body>
    <% if (loginUser != null) { %>
        <div><%=loginUser.getNm()%>님 환영합니다.</div>
    <% } %>
    <h1>리스트</h1>
    <div><a href="/write"><input type="button" value="글쓰기"></a></div>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일자</th>
        </tr>
    </table>
</body>
</html>

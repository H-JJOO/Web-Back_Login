<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = (String)request.getAttribute("err");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글수정</title>
</head>
<body>
<h1>글수정</h1>
<% if (err != null)  { %>
<div><%=err%></div>
<% } %>

<div>
    <!--쿼리스트링으로 iboard 값을 날리면 post 방식으로 iboard 값을 날려주는것과 동일한 효력을 가진다, 단 주소에 남는다-->
    <form action="/board/mod?iboard=${requestScope.data.iboard}" method="post" id="frm">
        <div>
            <input type="text" name="title" placeholder="title" value="${requestScope.data.title}">
        </div>
        <div>
            <textarea name="ctnt" placeholder="content" rows="20">${requestScope.data.ctnt}</textarea>
        </div>
        <div>
            <input type="submit" value="수정">
            <input type="reset" value="초기화">
            <input type="button" value="모두 삭제" onclick="removeAll()">
            <a href="/board/list"><input type="button" value="리스트"></a>
        </div>
    </form>

    <script>
        function removeAll() {
            var frm = document.querySelector('#frm');
            frm.title.value = '';
            frm.ctnt.value = '';
        }
    </script>
</div>
</body>
</html>

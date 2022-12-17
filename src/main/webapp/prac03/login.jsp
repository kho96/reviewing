<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// HttpSession으로 얻지 않아도 session이 생성되어 있기에 사용하면 된다.
	String result = (String)session.getAttribute("result"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<script>
	var result = "<%=result%>";
	if (result == "success") {
		alert("로그인 성공"); // 문제가 존재함 -> 세션은 브라우저를 종료시키지 않으면 계속 저장되어 있음.
		//세션에 저장된 특정 값을 지운다 -> 새로고침시 알람창 계속해서 보여지는 것 방지
		<% session.removeAttribute("result"); %>
		// 세션 자체를 무효화(초기화) 시키는 경우는 session.invalidate(); 를 사용하는 것이 깔끔함.
		// 특정 값만을 삭제하는 경우에는 session 자체는 존재하기 때문에 서버가 계속 이를 가지고 있어서 부담이 된다.
		// invalidate를 사용하는 것이 일반적, 주로 로그아웃에서 사용함.
		
	} else if (result == "fail") {
		alert("로그인 실패");
		// 세션을 지우지 않으면 새로 고침을 하여도 result 값이 존재해서 alert 계속 발동함.
	}
</script>
<body>
	<form action="/prac_servlet/sess3.login" method="get">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pwd"><br>
		이름 : <input type="name" name="name"><br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>
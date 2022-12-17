<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 요청 영역에 저장된 데이터 받기
	String requestId = (String)request.getAttribute("id"); // Object 반환 -> 다운캐스팅 필요
	String requestName = (String)request.getAttribute("name");
	
	// 세션 영역에 저장된 데이터 받기
	HttpSession session2 = request.getSession(); // 세션 얻기
	String sessionId = (String)session2.getAttribute("id"); // Object 반환 -> 다운캐스팅 필요
	String sessionName = (String)session2.getAttribute("name");
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionTest.jsp</title>
</head>
<body>
	<!-- 포워드, 리다이렉트에서도 역시 세션에 저장된 값은 잘 넘어온다. -->
	<!-- 새로고침 해도 값은 사라지지 않고 유지됨. -->
	requestId = <%=requestId %><br>
	requestName = <%=requestName %><br>
	sessionId = <%=sessionId %><br>
	sessionName = <%=sessionName %>
</body>
</html>
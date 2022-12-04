<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pwd = request.getParameter("pwd");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jspResultPage.jsp</title>
</head>
<body>
	<h1>JSP Result Page</h1>
	<p> 입력한 아이디 : <%=request.getParameter("id") %></p><br>
	<p> 입력한 비밀번호 : <%=pwd %></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 지시자 : <%@ %> 주로 page지시자나 include에서 사용한다.  --%>

<%-- 스크립트릿 : <% %> 기본, java 코드를 사용할 수 있다. --%>
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
	
<%-- 	표현식() : <%= %> 과 out.print() 비슷하다 생각하면된다. --%>
	<p> 입력한 아이디 : <%=request.getParameter("id") %></p><br>
	<p> 입력한 비밀번호 : <%=pwd %></p><br>
	<%-- <%@ inlcude file="include할 파일경로" %> include되는 코드를 추가하는 역할. --%>
	<%@ include file="image.jsp" %>
</body>
</html>
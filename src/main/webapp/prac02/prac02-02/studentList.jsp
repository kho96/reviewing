<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="prac02.ex02.jdbc_to_servlet01.StudentDao" %>
<%@ page import="prac02.ex02.jdbc_to_servlet01.StudentVo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
	StudentDao dao = StudentDao.getInstance(); // dao 얻기
	// dao에서 전체조회해서 얻은 List<StdentVo>를 request영역에 넣기
	ArrayList<StudentVo> list = (ArrayList<StudentVo>)dao.showAll();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentList.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function() {
	$("button").click(function() {
		location.href="/prac_servlet/prac02/prac02-02/studentRegisterPage.jsp";
	});
});
</script>
</head>
<body>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>학년</th>
			<th>반</th>
			<th>번호</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<!-- html코드 내에서 스크립트릿을 사용하는 경우 번거로움.. -->
		<% for(StudentVo vo : list) { %>
		<tr>
			<td><%= vo.getName() %></td>
			<td><%= vo.getGrade() %></td>
			<td><%= vo.getMyClass() %></td>
			<td><%= vo.getClass_no() %></td>
			<td><a href="/prac_servlet/student.test?mod=true&name=<%=vo.getName()%>">수정</a></td>
			<td><a href="/prac_servlet/student.test?del=true&name=<%=vo.getName()%>">삭제</a></td>
		</tr>
		<%} %>	
		
	</table>
	<button type="button">등록</button>
</body>
</html>
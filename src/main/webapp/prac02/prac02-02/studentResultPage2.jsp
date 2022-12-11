<%@ page import="prac02.ex02.jdbc_to_servlet02.StudentDao" %>
<%@ page import="prac02.ex02.jdbc_to_servlet02.StudentVo" %>
<%-- <%@ page import="import할 클래스 경로" %> : jsp에서 import 하는 방법! --%>
<!-- 생성한 클래스를 임포트할 경우 패키지명도 같이 적어야 임포트가 된다. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name"); // parameter로 넘어온 name가져오기
	StudentDao dao = StudentDao.getInstance(); // dao 얻기
	StudentVo vo = dao.studentByName(name); // dao에 학생정보를 조회시켜서 StudentVo로 받기
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentResultPage.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<form action="/prac_servlet/student.test2" method="post">
		<input type="hidden" name="modRun" value="true">
		<input type="hidden" name="orgName" value="<%=name%>">
		<table border="1">
			<!-- 위에서 얻어낸 StudentVo를 이용해서 값 보여주기 -->
			<tr>
				<th>이름</th>
				<td><input type="text" value="<%=vo.getName() %>" name="name"></td> <!-- 표현식에서는 세미콜론 사용하지 않는다. -->
			</tr>
			<tr>
				<th>학년</th>
				<td><input type="number" value="<%=vo.getGrade() %>" name="grade"></td> 
			</tr> 
			<tr>
				<th>반</th>
				<td><input type="number" value="<%=vo.getMyClass() %>" name="class"></td>
			</tr>
			<tr>
				<th>번호</th>
				<td><input type="number" value="<%=vo.getClass_no() %>" name="class_no"></td>
			</tr>
		</table>
		<button type="submit">수정 완료</button>
	</form>
</body>
</html>
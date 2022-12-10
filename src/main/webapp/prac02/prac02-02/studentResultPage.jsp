<%@ page import="prac02.ex02.jdbc_to_servlet01.StudentDao" %>
<%@ page import="prac02.ex02.jdbc_to_servlet01.StudentVo" %>
<%-- <%@ page import="import할 클래스 경로" %> : jsp에서 import 하는 방법! --%>
<!-- 생성한 클래스를 임포트할 경우 패키지명도 같이 적어야 임포트가 된다. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int class_no = (int)request.getAttribute("class_no"); // request에 저장한 class_no가져오기
	StudentDao dao = StudentDao.getInstance(); // dao 얻기
	StudentVo vo = dao.studentByClassNo(class_no); // dao에 학생정보를 조회시켜서 StudentVo로 받기
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentResultPage.jsp</title>
</head>
<body>
	<table>
		<tr>
			<th>이름</th>
			<th>학년</th>
			<th>반</th>
			<th>번호</th>
		</tr>
		<tr>
			<!-- 위에서 얻어낸 StudentVo를 이용해서 값 보여주기 -->
			<td><%=vo.getName() %></td> <!-- 표현식에서는 세미콜론 사용하지 않는다. -->
			<td><%=vo.getGrade() %></td> 
			<td><%=vo.getMyClass() %></td> 
			<td><%=vo.getClass_no() %></td> 
		</tr>
	</table>
</body>
</html>
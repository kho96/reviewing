<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentRegisterPage.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
$(function() {
	$("#register").click(function() {
		$("form").attr("style", "visibility: visible"); // 등록을 누르면 form 보여주기
	});
	$("#btnExit").click(function() {
		console.log("hello");
		$("form").attr("style", "visibility: hidden"); //취소를 누르면 form 숨기기
	});
	$("#list").click(function() {
		// 새로운 요청으로 서블릿에 전달하는 방식도 있지만, get 방식으로 "list"라는 이름으로 "show"를 넘김.
		location.href="/prac_servlet/prac02/prac02-02/studentList2.jsp";
	});
});
</script>
</head>
<body>
	<h3 id="register" class="btn btn-primary">등록</h3>
	<h3 id="list" class="btn btn-danger">목록</h3>
	<form action="/prac_servlet/student.test" method="post" style="visibility: hidden"> <!-- form 숨기기 -->
		이름 : <input type="text" name="name"required="required"><br>
		학년 : <input type="number" name="grade" required><br>
		반 : <input type="number" name="class" required><br>
		학급번호 : <input type="number" name="class_no" required><br>
		<button type="submit" class="btn btn-success">등록</button>
		<button type="button" id="btnExit" class="btn btn-warning">취소</button>
	</form>
</body>
</html>
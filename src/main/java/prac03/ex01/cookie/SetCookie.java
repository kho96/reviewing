package prac03.ex01.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie.set")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetCookie() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키?
		// 서버를 대신에 웹 브라우저에 상태를 저장 및 요청하고, 해당 정보를 서버에 보내 사용자를 식별하는 것
		// 쿠키의 구성 요소 - 이름, 값, 유효시간(초), 도메인(쿠키를 생성하는 사이트), 경로(쿠키를 공유할 기준 경로)
		
		// 쿠키생성
		Cookie cookie = new Cookie("id", "hong");
		// 한글의 경우 Encoding해야함.
		Cookie cookie2 = new Cookie("name", URLEncoder.encode("홍길동", "utf-8")); // 작동되지 않음.
		
		// 유효기간 설정
		cookie.setMaxAge(60*60*24); // setMaxAge(초단위); -- 60*60*24 -> 유효기간 1일 설정
		cookie2.setMaxAge(60*60);
		
		// 응답할 response에 쿠키담기
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		// 쿠키 출력해보기(테스트)
		PrintWriter out = response.getWriter();
		out.println("set cookie");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

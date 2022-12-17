package prac03.ex02.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess1")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionTest() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션?
		// 쿠키와 다르게 서버에 저장되는 정보를 말한다. -> 쿠키보다 보안에 있어서 유리함.
		// 브라우저 종료시 사라진다.
		
		// Session 얻기
		HttpSession session = request.getSession();
		String id = session.getId(); // 세션 id를 얻어온다. -> 로그인한 id값이 아님.
		// 얻어온 세션은 새로고침을 해도 존재한다. -> 브라우저 종료시 세션삭제 -> 다시 들어오면 새로운 세션이 생성됨.
		// 새로운 브라우저로 요청 시 -> 새로운 세션을 얻어온다.(브라우저당 세션 생성된다.)
		System.out.println(id);
		
		// Session에 값 넣기 (key, value)
		session.setAttribute("id", "hong");
		session.setAttribute("name", "홍길동");
		
		// 포워드 하는 경우
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/prac03/sessionTest.jsp");
		dispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

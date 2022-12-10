package prac02.ex01.request_scope;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/attr.test1")
public class AttributeTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AttributeTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 정보에 어떤 값을 저장하여 보내고 싶을 때 사용, setAttribute("보낼 객체 이름", 객체)
		request.setAttribute("name", "hong"); // String 전달
		request.setAttribute("age", 102); // int 전달
		String[] ids = {"홍길동", "의적", "영웅", "인물"};
		request.setAttribute("ids", ids); // 배열
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/attr.test2");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

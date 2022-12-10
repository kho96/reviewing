package prac01.ex02.move_page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward.test")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForwardTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("ForwardTestServlet ----------");
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		// RequestDispatcher는 다른 페이지로 이동이 가능한 forward() 메서드를 가진 객체이다.
		// new연산자로 생성하지 않고 요청받은 request에서 getRequestDispatcher("이동할 페이지 경로")를 사용하여 얻어낸다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/forwardResultPage.html");
		// 얻어낸 RequestDispatcher 객체를 이용하여 forward()메서드를 호출한다. -> sendRedirect와는 달리 요청정보를 가지고있음(주소창변화X)
		dispatcher.forward(request, response);
	}

}

package prac01.ex02.request_method;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test.get")
public class TestServletGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TestServletGet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request -> 클라이언트의 요청정보
		// name으로 전송한 value값을 얻어내기 -> request.getParameter("name명");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		System.out.println("id : " + id);
		System.out.println("pwd : " + pwd);
	}

}

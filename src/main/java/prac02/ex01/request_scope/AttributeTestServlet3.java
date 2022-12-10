package prac02.ex01.request_scope;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/attr.test3")
public class AttributeTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AttributeTestServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request스코프에 저장된 값 확인하기 --> 존재하지 않는다.
		System.out.println("test3응답===============");
		System.out.println("name : " + request.getAttribute("name"));
		System.out.println("age : " + request.getAttribute("age"));
		System.out.println("ids : " + request.getAttribute("ids"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

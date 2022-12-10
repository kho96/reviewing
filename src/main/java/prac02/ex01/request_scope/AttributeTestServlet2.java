package prac02.ex01.request_scope;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/attr.test2")
public class AttributeTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AttributeTestServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// 요청 정보에 저장 시킨 객체명으로 값 가져오기. getAttribute(객체명), Object 반환 -> 다운캐스팅 필요함.
		// getParameter -> String 반환, getAttribute -> Object반환(클래스 객체를 넘기기에 용이함, 모든 스코프에서 사용가능)
		String name = (String) request.getAttribute("name"); 
		int age= (int) request.getAttribute("age");
		String[] ids = (String[]) request.getAttribute("ids");
		System.out.println("test2응답===============");
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		for(String id : ids) {
			System.out.println("id : " + id);
		}
		
		response.sendRedirect("/prac_servlet/attr.test3"); // redirect의 경우 스코프 영역에 저장된 값 확인해보기
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package prac03.ex01.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie.get")
public class GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCookie() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("get cookie");
		// 쿠키정보는 요청정보에 있다.
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			String name = c.getName();
			String value = c.getValue();
			out.println("name:" + name);
			out.println("value:" + value);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

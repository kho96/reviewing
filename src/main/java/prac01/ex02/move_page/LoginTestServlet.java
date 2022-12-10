package prac01.ex02.move_page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.test")
public class LoginTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginTestServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id);
		System.out.println(pwd);
		// 출력할 때의 한글 깨짐 방지 -
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// html 코딩을 할 수 없기에 PrintWriter stream을 얻는다. (response에 이미 만들어져 있다.)
		PrintWriter out = response.getWriter();
		String html = "<html>";
		html += "<head>";
		html += "<meta cahrset='utf-8'>";
		html += "</head>";
		html += "<body>";
		if(id.equals("admin") && pwd.equals("1234")) {
			html += "<h1>관리자로 로그인 하셨습니다.</h1>";
		} else {
			html += id + "님 환영합니다.";
		}
		html += "</body>";
		html += "</html>";
		out.print(html); // 보여주고자 하는 html 코드를 출력한다.
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

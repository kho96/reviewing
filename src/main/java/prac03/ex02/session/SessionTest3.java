package prac03.ex02.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


@WebServlet("/sess3.login")
public class SessionTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SessionTest3() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("id");
		String userpwd = request.getParameter("pwd");
		String username = request.getParameter("name");
		
		HttpSession session = request.getSession();
		if (userid.equals("admin") && userpwd.equals("1234")) { // 로그인 정보가 일치하는 경우
			session.setAttribute("result", "success");
		} else { // 로그인 정보가 일치하지 않는 경우
			session.setAttribute("result", "fail");
		}
		response.sendRedirect("/prac_servlet/prac03/login.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

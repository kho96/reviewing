package prac03.ex02.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

@WebServlet("/sess2")
public class SessionTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionTest2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("id", "hong");
		session.setAttribute("name", "홍길동");
		
		// sendRedirect 역시 세션은 사라지지 않고 저장되어 있다.
		response.sendRedirect("/prac_servlet/prac03/sessionTest.jsp"); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package prac01.ex02.move_page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include.test")
public class IncludeTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IncludeTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("IncludeTestServlet -------");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//출력을 위한 PrintWriter 객체 얻기
		PrintWriter out = response.getWriter();
		
		// include 하기 위해 RequestDispatcher 객체 얻기
		RequestDispatcher dispatcher = request.getRequestDispatcher("/include.handle");
		// include 호출
		dispatcher.include(request, response);
		
		System.out.println("include 처리완료...");
		
		//include한 페이지에서 처리한 결과물을 가져와서 여기서 처리하는 것이 가능함.
		// request.getAttribute("객체명") -> 객체명으로 setAttribute한 객체를 가져온다. -> 반환타입은 Object라 casting필요함.
		String result = (String)request.getAttribute("result"); 
		out.println("<p>IncludeTest</p><br>");
		out.println("<p>" + result + "</p>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package prac02.ex02.jdbc_to_servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student.test")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao dao = StudentDao.getInstance(); // 서블릿에서 사용할 Dao객체 얻기
	
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int grade = Integer.parseInt(request.getParameter("grade"));
		int myClass = Integer.parseInt(request.getParameter("class"));
		int class_no = Integer.parseInt(request.getParameter("class_no"));
		
		// getParameter을 통해 얻은 데이터->StudentVo 생성
		StudentVo vo = new StudentVo(name, grade, myClass, class_no);
		// Dao -> 학생 등록(추가) 작업 시키기
		boolean result = dao.addStudent(vo);
		if (result) {
			request.setAttribute("class_no", class_no); // 등록 성공시 request영역에 class_no저장
			RequestDispatcher dispatcher = request.getRequestDispatcher("/prac02-02/studentResultPage.jsp");
			dispatcher.forward(request, response);
		} else {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.write("<html>");
			out.write("<head>");
			out.write("</head>");
			out.write("<body>");
			out.write("<h1>등록 오류입니다.</h1>");
			out.write("<h1><a href='/prac_servlet/prac02/prac02-02/studentRegisterPage.jsp'>돌아가기</a><h1>");
			out.write("</body>");
			out.write("</html>");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

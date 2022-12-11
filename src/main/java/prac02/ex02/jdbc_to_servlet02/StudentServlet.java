package prac02.ex02.jdbc_to_servlet02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student.test2")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao dao = StudentDao.getInstance(); // 서블릿에서 사용할 Dao객체 얻기
	
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("del") != null) {
			// 이름 중복 허용하지 않는다고 생각
			String name = request.getParameter("name");
			//System.out.println("name : " + name);
			boolean result = dao.deleteStudent(name);
			if (result) {
				response.sendRedirect("/prac_servlet/prac02/prac02-02/studentList2.jsp");
			} else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.write("<html>");
				out.write("<head>");
				out.write("</head>");
				out.write("<body>");
				out.write("<h1>삭제 오류입니다.</h1>");
				out.write("<h1><a href='/prac_servlet/prac02/prac02-02/studentRegisterPage2.jsp'>돌아가기</a><h1>");
				out.write("</body>");
				out.write("</html>");
			}
			return;
		}
		
		if (request.getParameter("mod") != null) {
			String name = request.getParameter("name"); // request영역에 name저장
			System.out.println("name :" + name);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/prac02/prac02-02/studentResultPage2.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		if (request.getParameter("modRun") != null) {
			String orgName = request.getParameter("orgName"); // 기존이름 받기
			System.out.println("orgName : " + orgName);
			String name = request.getParameter("name"); 
			int grade = Integer.parseInt(request.getParameter("grade"));
			int myClass = Integer.parseInt(request.getParameter("class"));
			int class_no = Integer.parseInt(request.getParameter("class_no"));
			StudentVo vo = new StudentVo(name, grade, myClass, class_no);
			boolean result = dao.modifyStudent(orgName, vo);
			if (result) {
				response.sendRedirect("/prac_servlet/prac02/prac02-02/studentList2.jsp");
			} else {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.write("<html>");
				out.write("<head>");
				out.write("</head>");
				out.write("<body>");
				out.write("<h1>수정 오류입니다.</h1>");
				out.write("<h1><a href='/prac_servlet/prac02/prac02-02/studentRegisterPage2.jsp'>돌아가기</a><h1>");
				out.write("</body>");
				out.write("</html>");
			}
			return;
		}
		
		String name = request.getParameter("name");
		int grade = Integer.parseInt(request.getParameter("grade"));
		int myClass = Integer.parseInt(request.getParameter("class"));
		int class_no = Integer.parseInt(request.getParameter("class_no"));
		
		// getParameter을 통해 얻은 데이터->StudentVo 생성
		StudentVo vo = new StudentVo(name, grade, myClass, class_no);
		// Dao -> 학생 등록(추가) 작업 시키기
		boolean result = dao.addStudent(vo);
		if (result) {
			response.sendRedirect("/prac_servlet/prac02/prac02-02/studentList2.jsp");
		} else {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.write("<html>");
			out.write("<head>");
			out.write("</head>");
			out.write("<body>");
			out.write("<h1>등록 오류입니다.</h1>");
			out.write("<h1><a href='/prac_servlet/prac02/prac02-02/studentRegisterPage2.jsp'>돌아가기</a><h1>");
			out.write("</body>");
			out.write("</html>");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

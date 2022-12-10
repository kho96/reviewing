package prac01.ex02.move_page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect.test")
public class RedirectTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RedirectTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("RedirectTestSelvlet -----");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age"); // getParameter는 무조건 String을 반환함.
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		
		// hobbies 배열 출력
		String my_hobbies = "";
		for (String str : hobbies) {
			if (str.equals(hobbies[hobbies.length-1])) {
				my_hobbies += str;
			} else {
				my_hobbies += str + ",";
			}
		}
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);
		System.out.println("취미 : " + my_hobbies);
		System.out.println("------------------------------------");
		
		// 재요청 -> response.sendRedirect("재요청 주소"); -> 새로운 요청을 시도함.(주소창 변화, 요청정보 초기화)
		response.sendRedirect("/prac_servlet/redirectResultPage.html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

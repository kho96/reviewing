package prac01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet {
	
	// servlet? -> java를 사용하여 웹페이지를 동적으로 생성하는 프로그램.
	// 클라이언트의 요청에 따라서 결과를 보여주기 위해 사용한다.
	
	// init() -> 최초 요청 시에 한 번만 실행된다. (서블릿에서 공통적으로 사용할 무언가가 있다면, 오버라이딩 하여 사용한다.)
	@Override
	public void init() throws ServletException {
		System.out.println("test : init()");
	}
	
	// get방식 요청에 대한 처리를 한다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("test : doGet()");
	}
	
	// post방식 요청에 대한 처리를 한다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("test : doPost()123");
	}
	
	// destroy() -> WAS(Web Application Service)가 종료되거나, 웹 어플리케이션이 새롭게 갱신될 경우 실행된다.
	// WAS? DB 조회 혹은 다양한 로직 처리를 요구하는 동적 컨텐츠를 제공하기 위해 만들어진 Application 서버이다. ex)Tomcat, JBoss, WebSphere 등
	@Override
	public void destroy() {
		System.out.println("test : destroy()");
	}
}

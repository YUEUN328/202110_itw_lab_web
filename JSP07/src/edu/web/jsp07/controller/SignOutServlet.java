package edu.web.jsp07.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignOutServlet
 */
@WebServlet(name = "signOutServlet", urlPatterns = { "/signout" })
public class SignOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("signOutServlet.doGet() 호출");
		
		// 로그아웃 처리
//		request.getSession().invalidate();
		HttpSession session = request.getSession(); // 요청에 해당하는 세션 객체를 찾음
		session.invalidate(); // 세션을 만료시킴. (WAS가 세션 객체를 지움)
		
		// 메인 페이지로 이동
		response.sendRedirect("main");
	}

}

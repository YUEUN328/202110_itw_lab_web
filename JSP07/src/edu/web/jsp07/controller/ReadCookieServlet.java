package edu.web.jsp07.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadCookieServlet
 */
@WebServlet(name = "readCookieServlet", urlPatterns = { "/get-cookie" })
public class ReadCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("readCookieServlet.doGet() 호출");
		
		// 클라이언트(브라우저)가 요청(request)에 실어서 보낸 Cookie를 WAS에서 확인하는 방법
		Cookie[] cookies = request.getCookies();
		
		// getCooikes() 메서드는 브라우저에서 전송된 쿠키가 없는 경우에는 null을 리턴
		if (cookies != null) { // 쿠키 배열이 null이 아닌 경우에
			for (Cookie c : cookies) { // 배열에 있는 Cookie 객체를 하나씩 꺼내서 반복하면서
				String name = c.getName(); // 쿠키 이름
				String value = c.getValue(); // 쿠키에 저장된 값
				System.out.println(name + " : " + value);
			
				// 서버에서 응답을 보낼 때 클라이언트(브라우저)가 저장하고 있는 쿠키를 만료시키는 방법
				if (name.equals("nickName")) {
					// 만료시킬 쿠키와 같은 이름의 쿠키 객체를 생성
					Cookie nickName = new Cookie("nickName", null); 
					// 새로 생성된 쿠키의 만료 기간은 0초로 설정
					nickName.setMaxAge(0);
					// 쿠키를 응답(response)에 포함시킴
					response.addCookie(nickName);
				}
			}
		}
		
		// Servlet -> View(JSP) 포워드
		request.getRequestDispatcher("/WEB-INF/02_read_result.jsp").forward(request, response);
	}

}

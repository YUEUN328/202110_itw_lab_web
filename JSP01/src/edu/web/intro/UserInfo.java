package edu.web.intro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet(name = "userInfo", urlPatterns = { "/userinfo" })
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("userInfo.doGet() 메서드 호출");
		
		// 응답(response)의 ContentType을 설정(HTML & UTF-8)
		response.setContentType("text/html; charset=UTF-8");
		
		// 응답(response)를 작성
		PrintWriter writer = response.getWriter();
		writer.append("<!doctype html>")
			.append("<html>")
			.append("<head>")
			.append("<title> JSP 1 </title>")
			.append("</head>")
			.append("<body>")
			.append("<h1> User Info 입력 페이지 </h1>")
			.append("<form action='userinfo' method='post'>")
			.append("<input type='text' name='userName' placeholder='이름 입력' autofocus required />")
			.append("<input type='submit' value='전송' />")
			.append("</form>")
			.append("</body>")
			.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("userInfo.doPost() 메서드 호출");
		
		// 클라이언트(브라우저)가 보낸 데이터(userName)를 읽음
		request.setCharacterEncoding("UTF-8"); // 클라이언트가 보내는 문자열 데이터의 인코딩 방식을 지정
		String userName = request.getParameter("userName");
		System.out.println("userName: " + userName);
		
		// 응답(response)을 만듧
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.append("<!doctype html>")
			.append("<html>")
			.append("<head>")
			.append("<title> JSP 1 </title>")
			.append("</head>")
			.append("<body>")
			.append("<h1> User Info 결과 페이지 </h1>")
			.append("<h2>")
			.append(userName + "님, 안녕하세요...!!!")
			.append("</h2>")
			.append("</body>")
			.append("</html>");
	}

}
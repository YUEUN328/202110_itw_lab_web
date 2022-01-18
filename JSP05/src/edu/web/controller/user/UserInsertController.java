package edu.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.domain.User;
import edu.web.service.UserService;
import edu.web.service.UserServiceImpl;

public class UserInsertController implements Action {

	private UserService userService = UserServiceImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userInsertController.execute() 메서드 호출");
		
		// 요청 방식을 알아냄
		String method = request.getMethod();
		if (method.equals("GET")) {
			return doGet(request, response);
		} else {
			return doPost(request, response);
		}
		
	}

	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userInsertController.doPost() 메서드 호출");

		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		User user = new User(userid, pwd, email, 0);
		
		userService.registerNewUser(user);
		
		// 사용자 메인 페이지로 이동
		return REDIRECT_PREFIX + "main"; // user/main으로 redirect
	}

	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userInsertController.doGet() 메서드 호출");
		return "/WEB-INF/user/user-insert.jsp";
	}

}

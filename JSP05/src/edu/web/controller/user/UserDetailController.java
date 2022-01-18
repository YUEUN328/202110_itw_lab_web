package edu.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.domain.User;
import edu.web.service.UserService;
import edu.web.service.UserServiceImpl;

public class UserDetailController implements Action {

	private UserService userService = UserServiceImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userDetailController.execute() 메서드 호출");
		
		// 제목을 클릭했을 때 해당 아이디(userid)의 모든 정보를 보여주는 페이지 
		// 1. request 객체에서 요청 파라미터 userid의 값을 읽음
		String userid = request.getParameter("userid");
		
		// 2. userService 객체의 메서드를 호출해서 사용자 정보를 가져옴
		User user = userService.select(userid);
		
		// 3. request 객체에 User 객체를 포함시켜서 View(JSP)로 포워드
		request.setAttribute("user", user);
		
		return "/WEB-INF/user/user-detail.jsp";
	}

}

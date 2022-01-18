package edu.web.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.domain.User;
import edu.web.service.UserService;
import edu.web.service.UserServiceImpl;

public class UserMainController implements Action {

	UserService userService = UserServiceImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userMainController.execute() 메서드 호출");
		
		List<User> list = userService.select();
		
		request.setAttribute("userList", list);
		
		return "/WEB-INF/user/user-main.jsp"; 
	}

}

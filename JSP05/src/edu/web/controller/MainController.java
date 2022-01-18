package edu.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("mainController.execute() 메서드 호출");
		
		// View를 담당하는 JSP 파일의 위치를 리턴
		return "/WEB-INF/index.jsp";
	}

}

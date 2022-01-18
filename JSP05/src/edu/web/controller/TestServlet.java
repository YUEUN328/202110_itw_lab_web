package edu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.domain.Board;
import edu.web.persistence.BoardDao;
import edu.web.persistence.BoardDaoImpl;
import edu.web.persistence.UserDao;
import edu.web.persistence.UserDaoImpl;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name = "testServlet", urlPatterns = { "/test" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardDao dao = BoardDaoImpl.getInstance();
		/*
		List<Board> list = dao.read();
		for (Board b : list) {
			System.out.println(b.getBno() + ", " + b.getTitle());
		}
		*/
		
		/*
		Board b = new Board(0, "test 0114", "테스트_20220114", "admin", null, 0, 0, null);
		int result = dao.create(b);
		System.out.println("insert result = " + result);
		*/
		
		UserDao userDao = UserDaoImpl.getInstance();
		/*
		int result = userDao.update(10, "admin");
		System.out.println("update point 결과 = " + result);
		*/
		
		/*
		Board board = dao.read(1);
		System.out.println(board.getBno());
		System.out.println(board.getTitle());
		System.out.println(board.getContent());
		System.out.println(board.getUserId());
		System.out.println(board.getRegDate());
		*/
		
		int result = dao.update(2);
		System.out.println("조회수 증가 결과 = " + result);
	}

}

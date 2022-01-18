package edu.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.domain.Board;
import edu.web.service.BoardService;
import edu.web.service.BoardServiceImpl;

// board/insert 요청(GET, POST)을 처리하는 Controller
public class BoardInsertController implements Action{

	private BoardService boardService = BoardServiceImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("boardInsertController.execute() 메서드 호출");
		
		// 요청 방식을 알아냄
		String method = request.getMethod();
		if (method.equals("GET")) {  // 요청 방식(request method)은 대문자로 비교해야 함!
			return doGet(request, response);
		} else {
			return doPost(request, response);
		}
		
	}

	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("boardInsertController.doPost() 메서드 호출");
		
		// request 객체에서 요청 파라미터들을 읽음.
		// 클라이언트(브라우저)에서 보낸 글 제목/내용/작성자 아이디를 찾음.
		String title = request.getParameter("title"); // 사용자가 form에 입력한 글 제목
		String content = request.getParameter("content"); // 사용자가 form에 입력한 글 내용
		String userId = request.getParameter("userId"); // 글 작성자 아이디
		
		// Board 객체 생성 -> DB 테이블에 insert될 데이터
		Board board = new Board(0, title, content, userId, null, 0, 0, null);
		
		// BoardService의 메서드를 사용해서 작성된 글을 DB에 insert한 후, 
		boardService.registerNewBoard(board);
		
		// 게시판 메인 페이지로 이동
		return REDIRECT_PREFIX + "main";  // board/main으로 redirect
	}

	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("boardInsertController.doGet() 메서드 호출");
		return "/WEB-INF/board/board-insert.jsp";
	}

}

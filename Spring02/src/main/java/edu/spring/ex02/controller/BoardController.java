package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.ex02.domain.Board;
import edu.spring.ex02.service.BoardService;

@Controller // DispatcherServlet에 의해서 컴포넌트 객체로 생성되고 관리됨
@RequestMapping(value = "/board")
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	// Service 계층의 객체들을 주입(injection)받아서 사용
	@Autowired private BoardService boardService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main(Model model) {
		log.info("main() 호출");
		
		// 서비스 객체의 메서드를 사용해서 글 전체 목록을 가져옴
		List<Board> list = boardService.select();
		// 글 전체 목록을 Model 객체에 속성으로 추가해서 View(JSP)까지 전달
		model.addAttribute("boardList", list);		
		
		// controller 메서드가 리턴하는 문자열이 없으면 요청 주소로 View(jsp 파일)을 찾음
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {
		log.info("insert() GET 방식 호출");
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(Board board) {
		log.info("insert({}) POST 호출", board);
		
		// 클라이언트에서 보낸 데이터들을 서비스 계층의 메서드 객체 (메서드)를 사용해서 새 글 작성 서비스 완료 후 
		// 게시판 메인 페이지로 이동(redirect)
		boardService.insert(board);
		
		return "redirect:/board/main";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void detail(int bno, Model model) {
		log.info("detail(bno={}) GET 호출", bno);
		
		// 서비스 계층의 객체 (메서드)를 사용해서 해당 글 번호(bno)를 검색하고
		// 검색된 내용을 View(JSP)에게 전달
		Board board = boardService.select(bno);
		model.addAttribute("board", board);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void update(int bno, Model model) {
		log.info("update(bno={}) GET 호출", bno);
		
		Board board = boardService.select(bno);
		model.addAttribute("board", board);
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Board board) {
		log.info("update({}) POST 호출", board);
		
		boardService.update(board); // 게시글 수정 서비스 완료
		
		return "redirect:/board/main"; // 게시판 메인으로 이동
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int bno) {
		log.info("delete(bno={}) 호출", bno);
		
		boardService.delete(bno);
		
		return "redirect:/board/main";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(int type, String keyword, Model model) {
		log.info("search(type={}, keyword={})", type, keyword);
		
		List<Board> list = boardService.select(type, keyword); // 검색 결과
		// 검색 결과를 Model 객체에 속성(attribute)으로 추가해서 view에 전달
		model.addAttribute("boardList", list); // jsp 파일에서 ${boardList} EL로 사용되기 때문에
		
		return "board/main"; // "/WEB-INF/views/" + "board/main" + ".jsp" 파일을 view로 사용
	}

}
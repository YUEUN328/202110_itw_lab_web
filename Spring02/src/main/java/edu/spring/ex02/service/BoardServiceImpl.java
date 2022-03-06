package edu.spring.ex02.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.Board;
import edu.spring.ex02.persistence.BoardDao;
import edu.spring.ex02.persistence.UserDao;

@Service // 스프링 컨테이너(프레임워크)가 서비스 컴포넌트로 생성하고 관리하기 위해서
public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	// Service 계층은 Persistence(Repository) 계층의 객체를 주입(injection) 받아서 사용
	@Autowired private BoardDao boardDao;
	@Autowired private UserDao userDao;
	
	@Override
	public List<Board> select() {
		log.info("select() 호출");
		
		return boardDao.read();
	}

	@Override
	public int insert(Board board) {
		log.info("insert({}) 호출", board);
		
		// (1) boards 테이블에 새 글 insert
		int result = boardDao.create(board);
		// (2) 글을 작성한 사용자의 points를 10점 증가.
		userDao.updatePoints(board.getUserid(), 10);
		
		return result;
	}

	@Override
	public Board select(int bno) {
		log.info("select(bno={}) 호출", bno);
		
		Board board = boardDao.read(bno); // 해당 글 번호의 게시글을 찾음
		boardDao.updateViewCnt(bno); // 조회수를 증가
		
		return board; // 검색한 Board 객체를 리턴
	}

	@Override
	public int update(Board board) {
		log.info("update({}) 호출", board);

		return boardDao.update(board);
	}
	
	@Override
	public int delete(int bno) {
		log.info("delete(bno={}) 호출", bno);
		
		return boardDao.delete(bno);
	}

	@Override
	public List<Board> select(int searchType, String searchKeyword) {
		log.info("select(searchType={}, searchType={})", searchType, searchKeyword);
		
		return boardDao.read(searchType, searchKeyword);
	}
	
}

package edu.web.service;

import java.util.List;

import edu.web.domain.User;

public interface UserService {

	/**
	 * Persistence 계층(UserDao)의 read 메서드를 호출해서 사용자 전체 목록을 반환하는 메서드.
	 * 
	 * @return User를 원소로 갖는 ArrayList.
	 */
	List<User> select();
	
	/**
	 * 신규 회원 등록 서비스:
	 * users 테이블에 신규 회원 insert.
	 * 
	 * @param user DB users 테이블에 insert할 userid, pwd, email을 가지고 있는 객체.
	 * @return 성공하면 1, 실패하면 0.
	 */
	int registerNewUser(User user);
	
	/**
	 * 사용자 상세보기 서비스:
	 * 아이디(userid)를 전달받아서 해당 아이디의 모든 정보를 검색.
	 * 
	 * @param userid 검색하려는 아이디(primary key).
	 * @return userid의 사용자 정보를 가지고 있는 User 객체.
	 */
	User select(String userid);
}

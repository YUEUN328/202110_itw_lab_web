package edu.web.persistence;

import static edu.web.domain.User.Entry.*;

import java.util.List;

import edu.web.domain.User;

public interface UserDao {
	
	// update USERS set POINTS = POINTS + ? where USERID = ?;
	String SQL_UPDATE_USER_POINTS = String.format(
			"update %s set %s = %s + ? where %s = ?", 
			TABLE_USER, COL_POINTS, COL_POINTS, COL_USERID);	
	/**
	 * DB users 테이블에서 userId의 points 컬럼 값을 증가.
	 * 
	 * @param points 증가시킬 값.
	 * @param userId 수정할 userid(테이블의 고유키)
	 * @return
	 */
	int update(int points, String userId);
	
	// 전체 검색: select * from users;
	String SQL_SELECT_ALL = String.format(
			"select * from %s", 
			TABLE_USER);
	/**
	 * DB USERS 테이블에서 전체 검색 결과를 리턴하는 메서드.
	 * 
	 * @return User 객체를 원소로 갖는 ArrayList.
	 */
	List<User> read();
	
	// 신규 회원 등록: insert into users (userid, pwd, email) values (?, ?, ?);
	String SQL_INSERT_USER = String.format(
			"insert into %s (%s, %s, %s) values (?, ?, ?)", 
			TABLE_USER, COL_USERID, COL_PWD, COL_EMAIL);
	/**
	 * DB users 테이블에 새 레코드를 삽입.
	 * 
	 * @param user users 테이블에 insert할 userid, pwd, email을 갖고 있는 객체.
	 * @return insert 성공하면 1, 실패하면 0.
	 */
	int create(User user);
	
	// 사용자 상세보기: select * from USERS where USERID = ?;
	String SQL_SELECT_BY_USERID = String.format(
			"select * from %s where %s = ?", 
			TABLE_USER, COL_USERID);
	/**
	 * 아이디(userid)를 argument로 전달받아서 DB users 테이블에서 사용자 정보 1개를 검색하고,
	 * 그 결과를 리턴.
	 * 
	 * @param userid 아이디. 테이블의 primary key(고유키).
	 * @return 해당 아이디의 사용자 전체 정보를 가지고 있는 User 객체.
	 */
	User read(String userid);
}

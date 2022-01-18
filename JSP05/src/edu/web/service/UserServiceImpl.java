package edu.web.service;

import java.util.List;

import edu.web.domain.User;
import edu.web.persistence.UserDao;
import edu.web.persistence.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	//  Singleton 패턴
	private static UserServiceImpl instance = null;
	
	private UserServiceImpl() {
		userDao = UserDaoImpl.getInstance();
	}
	
	public static UserServiceImpl getInstance() {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<User> select() {
		System.out.println("userServiceImpl.select() 메서드 호출");
		return userDao.read();
	}

	@Override
	public int registerNewUser(User user) {
		System.out.println("userServiceImpl.registerNewUser(user) 메서드 호출");
				
		return userDao.create(user); 
	}

	@Override
	public User select(String userid) {
		System.out.println("userServiceImpl.select(userid=" + userid + ") 메서드 호출");
		
		return userDao.read(userid);
	}

}

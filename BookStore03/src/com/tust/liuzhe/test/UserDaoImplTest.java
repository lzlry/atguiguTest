package com.tust.liuzhe.test;

import org.junit.jupiter.api.Test;

import com.tust.liuzhe.bean.User;
import com.tust.liuzhe.dao.UserDao;
import com.tust.liuzhe.dao.impl.UserDaoImpl;

class UserDaoImplTest {
	private UserDao userDao = (UserDao) new UserDaoImpl();

	@Test
	void testGetUser() {
		User user = userDao.getUser(new User(null, "test01", "test01", null));
		System.out.println(user);
	}
	@Test
	void testCheckUserName() {
		boolean yOn = userDao.checkUserName("test01t");
		System.out.println(yOn);
	}

}

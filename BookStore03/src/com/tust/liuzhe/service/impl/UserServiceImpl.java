package com.tust.liuzhe.service.impl;

import com.tust.liuzhe.bean.User;
import com.tust.liuzhe.dao.UserDao;
import com.tust.liuzhe.dao.impl.UserDaoImpl;
import com.tust.liuzhe.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao =  new UserDaoImpl();
	@Override
	public User getUser(User user) {
		
		return userDao.getUser(user);
	}
	@Override
	public boolean checkUserName(String username) {
		
		return userDao.checkUserName(username);
	}
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
		
	}


}

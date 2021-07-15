package com.tust.liuzhe.service;

import com.tust.liuzhe.bean.User;

public interface UserService {
	/**
	 * 登录用的方法 
	 * @param user
	 * @return
	 */
	User getUser(User user);
	
	/**
	 * 注册、检查用户名是否存在
	 */
	boolean checkUserName(String username);
	
	void saveUser(User user);
	
}

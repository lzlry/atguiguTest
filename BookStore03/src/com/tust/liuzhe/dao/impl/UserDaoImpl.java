package com.tust.liuzhe.dao.impl;

import com.tust.liuzhe.bean.User;
import com.tust.liuzhe.dao.BaseDao;
import com.tust.liuzhe.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public User getUser(User user) {
		String sql = "select id,username,`password`,email from users where username = ? and password = ?";
		User userq = this.getBean(sql,user.getUsername(),user.getPassword());
		return userq;
	}

	@Override
	public boolean checkUserName(String username) {
		String sql = "select id,username,`password`,email from users where username=?";
		User user = this.getBean(sql, username);
		return user!=null;
		
	}

	@Override
	public void saveUser(User user) {
		String sql = "insert into users(username,`password`,email) values (?,?,?)";
		this.update(sql, user.getUsername(),user.getPassword(),user.getEmail());
	}
	
	

}

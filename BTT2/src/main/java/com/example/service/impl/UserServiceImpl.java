package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.model.User;
import com.example.service.UserService;

public class UserServiceImpl implements UserService {
	@Override
	public User login(String username, String password){
		UserDao userDao = new UserDaoImpl();
		User user = userDao.get(username);
		if (user != null && user.getPassWord().equals(password)) {
			return user;
		}
		return null;
	}
}

package com.example.service.ServieImpl;

import com.example.dao.daoImpl.UserDaoImpl;
import com.example.model.User;
import com.example.service.UserService;

public class UserServiceImpl implements UserService{
	public UserDaoImpl userDao = new UserDaoImpl();
	@Override
	public User Login(String userName, String passWord) {
		return userDao.findUser(userName, passWord);

	}
}
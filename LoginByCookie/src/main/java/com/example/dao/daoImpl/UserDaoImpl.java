package com.example.dao.daoImpl;

import com.example.dao.UserDao;
import com.example.model.User;

public class UserDaoImpl implements UserDao{
	
	public User findUser(String userName, String passWord) {
		if("admin".equals(userName) &&"123".equals(passWord)) {
			return new User(userName, passWord);
		}
		return null;
	}
	
}
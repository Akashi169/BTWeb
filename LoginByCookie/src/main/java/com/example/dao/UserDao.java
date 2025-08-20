package com.example.dao;

import com.example.model.User;

public interface UserDao {
	User findUser(String userName, String passWord);

}

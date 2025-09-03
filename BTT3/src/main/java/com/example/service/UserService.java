package com.example.service;

import com.example.model.User;

public interface UserService {
	User login(String username, String password);
	User findByEmail(String email);
	void updatePasswordByEmail(String email, String newPassword);
}

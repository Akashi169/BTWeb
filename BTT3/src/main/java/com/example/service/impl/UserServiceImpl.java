package com.example.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.model.User;
import com.example.service.UserService;
import com.example.utils.DBConnection;

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
	@Override 
	public User findByEmail(String email) {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserByEmail(email);
		if (user != null) {
			return user;
		}
		return null;
	}
	@Override
	public void updatePasswordByEmail(String email, String newPassword) {
	    String sql = "UPDATE User SET password = ? WHERE email = ?";
	    User user = null;
		try {
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, email);
			
			ResultSet rs = ps.executeQuery(sql);
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

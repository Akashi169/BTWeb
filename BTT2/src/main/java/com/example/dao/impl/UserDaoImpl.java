package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.utils.DBConnection;

public class UserDaoImpl implements UserDao{
	@Override
	public User get(String username) {
		String sql = "SELECT * FROM User WHERE username = ? ";
		User user = null;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					user = new User();
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("email"));
					user.setUserName(rs.getString("username"));
					user.setFullName(rs.getString("fullname"));
					user.setPassWord(rs.getString("password"));
					user.setAvatar(rs.getString("avatar"));
					user.setRoleid(Integer.parseInt(rs.getString("roleid")));
					user.setPhone(rs.getString("phone"));
					user.setCreatedDate(rs.getDate("createdDate"));
	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
}

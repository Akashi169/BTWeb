package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.CategoryDao;
import com.example.model.Category;
import com.example.utils.DBConnection;

public class CategoryDaoImpl {
	// @Override
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		String sql = "SELECT * FROM Category ";

		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int userId = rs.getInt("userId");
					String imageUrl = rs.getString("imageUrl");
					categories.add(new Category(id, name, userId, imageUrl));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return categories;
	}

	// @Override
	public void addCategory(Category category) {
		String sql = "INSERT INTO category(name,userId,imageUrl) VALUES(?,?,?)";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, category.getName());
			ps.setInt(2, category.getUserId());
			ps.setString(3, category.getImageUrl());
		
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCategory(Category category) {
	    String sql = "UPDATE category SET name=?, userId=?, imageUrl=? WHERE id=?";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, category.getName());

	        if (category.getUserId() == null) {
	            ps.setNull(2, java.sql.Types.INTEGER);
	        } else {
	            ps.setInt(2, category.getUserId());
	        }

	        if (category.getImageUrl() == null) {
	            ps.setNull(3, java.sql.Types.VARCHAR);
	        } else {
	            ps.setString(3, category.getImageUrl());
	        }

	        ps.setInt(4, category.getId());

	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void deleteCategory(int id) {
		String sql = "DELETE FROM category WHERE id = ?";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

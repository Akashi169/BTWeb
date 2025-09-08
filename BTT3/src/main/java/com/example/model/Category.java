package com.example.model;

public class Category {
	public Integer id;
	public String name;
	public Integer userId;
	public String imageUrl;
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserId() {
		return userId;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Category(int id, String name, int userId, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.imageUrl = imageUrl;
	}
	public Category(String name, Integer userId, String imageUrl) {
		this.name = name;
		this.userId = userId;
		this.imageUrl = imageUrl;
	}
	
}

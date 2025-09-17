package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="category")

public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="userdId", referencedColumnName="id")
	private User user;
	
	
	@Column(name="imageUrl")
	private String imageUrl;
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public Integer getUserId() {
//		return userId;
//	}
	
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
		//this.userId = userId;
		this.imageUrl = imageUrl;
	}
	public Category(String name, Integer userId, String imageUrl) {
		this.name = name;
		this.user.setId(userId);
		this.imageUrl = imageUrl;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

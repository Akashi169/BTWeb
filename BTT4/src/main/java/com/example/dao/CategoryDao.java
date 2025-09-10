package com.example.dao;
import java.util.List;
import com.example.model.Category;

public interface CategoryDao{
	List<Category> getAllCategories();
	void addCategory(Category category);
}

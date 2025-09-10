package com.example.controller;

import java.io.IOException;
import java.util.List;

import com.example.dao.impl.CategoryDaoImpl;
import com.example.model.Category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/categories/*")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listCategories(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//
		String action = request.getPathInfo();
		if (action == null || action.equals("/")) {
			listCategories(request, response);
		} else if ("/add".equals(action)) {
			addCategory(request, response);
		} else if ("/delete".equals(action)) {
			deleteCategory(request, response);
		} else if ("/update".equals(action)) {
			updateCategory(request, response);
		}

	}

	private void listCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> categories = categoryDaoImpl.getAllCategories();
		req.setAttribute("categories", categories);
		req.getRequestDispatcher("/WEB-INF/view/category-form.jsp").forward(req, resp);
	}

	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		Integer userId = null;
		String UserIdParam = request.getParameter("userId");

		String imageUrl = request.getParameter("imageUrl");
		if (imageUrl == null || imageUrl.isEmpty()) {
			imageUrl = null;
		}
		if (UserIdParam != null) {
			userId = Integer.parseInt(UserIdParam);
		}
		Category newCategory = new Category(name, userId, imageUrl);

		try {
			categoryDaoImpl.addCategory(newCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/categories");
	}

	private void updateCategory(HttpServletRequest req, HttpServletResponse resp) 
	        throws IOException {
	    int id = Integer.parseInt(req.getParameter("id"));
	    String name = req.getParameter("name");

	    Integer userId = null;
	    String userIdParam = req.getParameter("userId");
	    if (userIdParam != null && !userIdParam.isEmpty()) {
	        userId = Integer.parseInt(userIdParam);
	    }

	    String imageUrl = req.getParameter("imageUrl");
	    if (imageUrl != null && imageUrl.isEmpty()) {
	        imageUrl = null;
	    }

	    Category category = new Category(id, name, userId, imageUrl);
	    categoryDaoImpl.updateCategory(category);

	    resp.sendRedirect(req.getContextPath() + "/categories");
	}

	private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		categoryDaoImpl.deleteCategory(id);
		resp.sendRedirect(req.getContextPath() + "/categories");
	}
}

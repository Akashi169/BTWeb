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

@WebServlet(urlPatterns={"/home","/*"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
		
    	
	  	List<Category> categories = categoryDaoImpl.getAllCategories();
	  		  	
    	request.setAttribute("categories",categories);
    	request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}

}

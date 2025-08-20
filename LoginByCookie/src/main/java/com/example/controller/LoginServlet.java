package com.example.controller;

import java.io.IOException;

import com.example.model.User;
import com.example.service.ServieImpl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	
	//private UserService userService = new UserService();
	
	@Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		UserServiceImpl userService = new UserServiceImpl();
		
		User user = userService.Login(userName, passWord);
		
		if( user != null) {
			Cookie cookie = new Cookie("userName", user.getUserName());
			cookie.setMaxAge(300);
			
			response.addCookie(cookie);
			response.getWriter().println("home.jsp");
		} else {
			 response.getWriter().println("login.jsp");
		}
		
		
	}
	
}

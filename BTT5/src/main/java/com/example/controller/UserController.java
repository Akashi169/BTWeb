package com.example.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.dao.impl.UserDaoImpl;
import com.example.model.Category;
import com.example.model.User;
import com.example.utils.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao = new UserDaoImpl();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if ( session == null || session.getAttribute("user")==null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		User user = (User)session.getAttribute("user");
		request.setAttribute("user",user);
		userDao.updateUser(user);
		request.getRequestDispatcher("/WEB-INF/view/user-form.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
	        if (session == null || session.getAttribute("user") == null) {
	            response.sendRedirect(request.getContextPath() + "/login");
	            return;
	        }

	        User user = (User) session.getAttribute("user");
	        
	        String phone = request.getParameter("phone");
	        String password = request.getParameter("password");
	        String avatar = request.getParameter("avatar"); 
	        
	        user.setPhone(phone);
	        user.setPassWord(password);
	        user.setAvatar(avatar);
	        
	        userDao.updateUser(user);
	        
	        session.setAttribute("user", user);

	        session.setAttribute("message", "Cập nhật thành công!");
	        response.sendRedirect(request.getContextPath() + "/home");
	}
}

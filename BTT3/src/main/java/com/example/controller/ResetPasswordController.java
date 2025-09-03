package com.example.controller;

import java.io.IOException;

import com.example.model.User;
import com.example.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ResetPasswordController
 */
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.getRequestDispatcher("/WEB-INF/view/reset.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String newPassword = request.getParameter("newPassword");
	        String confirmPassword = request.getParameter("confirmPassword");

	        HttpSession session = request.getSession();
	        User user = (User) session.getAttribute("resetUser");

	        if (user == null) {
	            response.sendRedirect("forgot");
	            return;
	        }

	        if (!newPassword.equals(confirmPassword)) {
	            request.setAttribute("alert", "Mật khẩu không khớp!");
	            request.getRequestDispatcher("/WEB-INF/view/reset.jsp").forward(request, response);
	            return;
	        }

	    
	        UserServiceImpl userService = new UserServiceImpl();
	        //userService.updatePassword(user.getId(), newPassword);
	  
	        session.removeAttribute("resetUser");

	        response.sendRedirect("login");
	    }
	}



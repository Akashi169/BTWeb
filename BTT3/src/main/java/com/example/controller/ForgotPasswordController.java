package com.example.controller;

import java.io.IOException;

import com.example.model.User;
import com.example.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgotPasswordController
 */
@WebServlet("/forgot")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }
    private UserServiceImpl userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/view/forgot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String email = request.getParameter("email");
	        String newPassword = request.getParameter("newPassword");

	        User user = userService.findByEmail(email);

	        if (user != null) {
	            // Cập nhật mật khẩu bằng email
	            userService.updatePasswordByEmail(email, newPassword);
	            //request.setAttribute("message", "Đổi mật khẩu thành công. Vui lòng đăng nhập lại.");
	            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	        } else {
	            request.setAttribute("alert", "Email không tồn tại trong hệ thống!");
	        }

	        request.getRequestDispatcher("/WEB-INF/view/forgot.jsp").forward(request, response);
	}

}

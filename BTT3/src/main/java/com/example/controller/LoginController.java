package com.example.controller;

import java.io.IOException;


import com.example.model.User;
import com.example.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserServiceImpl userService = new UserServiceImpl();
		
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        User user = userService.login(username, password);
//        if ( username == null || username.trim().isEmpty()||
//        	 password == null || password.trim().isEmpty())
//        {
//        	 request.setAttribute("alert", "Tên đăng nhập và mật khẩu không được bỏ trống");
//             request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
//             return;
//        }
        
     
        
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(300); 
            
            if ("on".equals(remember)) {
               
                jakarta.servlet.http.Cookie ckUser = new jakarta.servlet.http.Cookie("username", username);
                ckUser.setMaxAge(60 * 60 * 24 * 7); 
                response.addCookie(ckUser);

              
                jakarta.servlet.http.Cookie ckPass = new jakarta.servlet.http.Cookie("password", password);
                ckPass.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(ckPass);
            }
            
            request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
        } else {
            request.setAttribute("alert", "Sai username hoặc password");
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        }
		//doGet(request, response);
	}

}

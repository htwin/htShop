package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.pojo.User;
import com.shop.service.UserService;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService service = new UserService();
		
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//获取校验码
		String checkCode = request.getParameter("checkCode");
		//获取真的验证码
		String realCheckCode = (String) request.getSession().getAttribute("realCheckCode");
		
		if(!checkCode.equalsIgnoreCase(realCheckCode)) {   
			//回显用户名密码
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.getSession().setAttribute("error","验证码错误！！！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		User user = service.login(username, password);
		if(user == null) {
			//回显用户名密码
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.getSession().setAttribute("error","用户名或密码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		} 
		//code 1激活  0未激活
		if(user.getState()!=1) {
			//回显用户名密码
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.getSession().setAttribute("error","用户未激活，请前往邮箱激活。。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("username", username); 
		request.getSession().setAttribute("user", user); 
		response.sendRedirect("indexServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

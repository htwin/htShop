package com.shop.controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.pojo.User;
import com.shop.service.UserService;
import com.shop.utils.DateStrUtils;

public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();
		request.setCharacterEncoding("utf-8");
		//获取注册页面传来的参数
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String birthdayStr = request.getParameter("birthday");
		//日期转换
		Date birthday = DateStrUtils.stringToDate("yyyy-MM-dd", birthdayStr);
		String sex = request.getParameter("sex");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		User user = new User();//封装user对象
		user.setUsername(username);
		user.setName(name); 
		user.setPassword(password);
		user.setBirthday(birthday);
		user.setSex(sex);
		user.setTelephone(telephone);
		user.setEmail(email);
		user.setState(0);//是否为激活用户，0未激活   1激活
		user.setUid(UUID.randomUUID().toString());
		user.setCode(UUID.randomUUID().toString());//激活码
		boolean success = service.register(user,request);
		if(success) {  
			response.setContentType("text/html;charset=utf-8"); 
			request.getSession().setAttribute("registerMessage", "注册成功！请前往邮箱"+email+"激活账户!");//注册成功信息，回显邮箱，通知用户去邮箱激活
			response.sendRedirect("login.jsp"); 
		}else {
			response.getWriter().println("<script>alert('注册失败！！')</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

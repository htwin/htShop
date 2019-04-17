package com.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.pojo.Order;
import com.shop.pojo.User;
import com.shop.service.OrderService;

public class MyOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		//用户没有登录返回登录页面
		if(user == null) {
			response.sendRedirect("login.jsp");
			return ;
		}
		
		OrderService service = new OrderService();
		List<Order> orderList = service.getOrderList(user.getUid());//获取订单列表
		
		request.getSession().setAttribute("orderList", orderList);
		response.sendRedirect("orderList.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

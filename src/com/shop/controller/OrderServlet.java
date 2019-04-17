package com.shop.controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.pojo.Cart;
import com.shop.pojo.CartItem;
import com.shop.pojo.Order;
import com.shop.pojo.OrderItem;
import com.shop.pojo.User;
import com.shop.service.OrderService;

public class OrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//获取用户
		User user = (User) session.getAttribute("user");
		if(user == null) {
			//没有登录。返回登录页面
			response.sendRedirect("login.jsp");
			return;
		}
		
		//获取表单信息
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		
		//获取购物车对象
		Cart cart = (Cart) session.getAttribute("cart");
		
		//封装订单order对象
		Order order = new Order();
		order.setState(0);//0没有支付  1已支付
		order.setOid(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setUser(user);
		order.setTelephone(telephone);
		order.setName(name);
		order.setTotal(cart.getTotalPrice());
		order.setAddress(address);
		for(CartItem item:cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItemid(UUID.randomUUID().toString());
			orderItem.setCount(item.getNum());
			orderItem.setProduct(item.getProduct());
			orderItem.setSubtotal(item.getSubTotal());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		//调用服务
		OrderService service = new OrderService();
		service.saveOrder(order);
		response.sendRedirect("myOrderServlet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

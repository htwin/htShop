package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.pojo.Cart;
import com.shop.pojo.Product;
import com.shop.service.ProductService;

public class AddCartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductService service = new ProductService();
		
		//判断是否登录
		String username = (String)request.getSession().getAttribute("username");
		if(username==null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		//根据id查询商品
		String pid = request.getParameter("pid");
		Product product = service.getProductById(pid);
		//获取添加商品数量
		String numStr = request.getParameter("num");
		//默认为1
		if(numStr == null) {
			numStr = "1";
		}
		int num = Integer.parseInt(numStr);
		//获取购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//购物车为空
		if(cart == null) {
			cart = new Cart();
		}
		
		//将该商品添加到购物车
		cart.addCart(product,num);
		
		request.getSession().setAttribute("cart", cart);
		
		response.sendRedirect("cart_see.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

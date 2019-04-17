package com.shop.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.pojo.Product;
import com.shop.service.ProductService;

public class GoodsDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = new ProductService();
		String pid = request.getParameter("pid");
		Product product = service.getProductById(pid);
		request.setAttribute("product",product);
		
		//获得客户端携带cookie---获得名字是pids的cookie
		String pids = ""+pid;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if("pids".equals(cookie.getName())) {
					//pids: 1-2-3-5   8
					pids = cookie.getValue();
					String[] split = pids.split("-");
					List<String> asList = Arrays.asList(split);
					LinkedList<String> list = new LinkedList<String>(asList);
					if(list.contains(""+pid)) {
						list.remove(""+pid);
						list.addFirst(""+pid);
					}else {
						list.addFirst(""+pid);
					}
					
					StringBuffer sb = new StringBuffer();
					for(int i=0;i<list.size()&&i<6;i++) {
						sb.append(list.get(i));
						sb.append("-");
					}
					pids = sb.substring(0,sb.length()-1);
				}
			}
		}
		Cookie cookie_pids = new Cookie("pids",pids);
		response.addCookie(cookie_pids);
		request.getRequestDispatcher("goodsDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

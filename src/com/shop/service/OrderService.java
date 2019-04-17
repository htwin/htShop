package com.shop.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import com.shop.dao.OrderDao;
import com.shop.pojo.Order;
import com.shop.pojo.OrderItem;

public class OrderService {
	
	OrderDao orderDao = new OrderDao();
	
	public void saveOrder(Order order) {
		try {
			orderDao.saveOrder(order);
			for(OrderItem item:order.getOrderItems()) {
				orderDao.saveItem(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Order> getOrderList(String uid) {
		try {
			return orderDao.getOrderList(uid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

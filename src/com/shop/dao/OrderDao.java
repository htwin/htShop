package com.shop.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.mchange.v2.beans.BeansUtils;
import com.shop.pojo.Order;
import com.shop.pojo.OrderItem;
import com.shop.pojo.Product;
import com.shop.utils.C3P0Utils;

public class OrderDao {

	public void saveOrder(Order order) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		runner.update(sql,order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),
				order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid());
	}

	public void saveItem(OrderItem item) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into orderitem values(?,?,?,?,?)";
		runner.update(sql,item.getItemid(),item.getCount(),item.getSubtotal(),item.getProduct().getPid(),item.getOrder().getOid());
	}

	public List<Order> getOrderList(String uid) throws SQLException, IllegalAccessException, InvocationTargetException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from orders where uid = ?";
		List<Order> orderList = runner.query(sql,new BeanListHandler<Order>(Order.class),uid);
		for (Order order : orderList) {
			sql = "select * from orderitem o ,product p where o.pid=p.pid and o.oid=?";
			List<Map<String, Object>> olist = runner.query(sql, new MapListHandler(),order.getOid());
			for(Map<String,Object> map:olist) {
				OrderItem item = new OrderItem();
				BeanUtils.populate(item, map);
				Product product = new Product();
				BeanUtils.populate(product, map);
				item.setOrder(order);
				item.setProduct(product);
				order.getOrderItems().add(item);
			}
		}
		return orderList;
	}

}

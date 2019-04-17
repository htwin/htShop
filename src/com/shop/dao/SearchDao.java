package com.shop.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.shop.pojo.Product;
import com.shop.utils.C3P0Utils;
 
public class SearchDao {
	public List<Product> search(String searchword) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pname like '%"+searchword+"%'";   
		List<Product> productList = queryRunner.query(sql,new BeanListHandler<Product>(Product.class));
		return productList;
	}
}

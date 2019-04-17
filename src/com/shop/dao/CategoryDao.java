package com.shop.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.shop.pojo.Category;
import com.shop.utils.C3P0Utils;

public class CategoryDao {
	/**
	 * 查询分类列表
	 * @return
	 * @throws SQLException 
	 */
	public List<Category> getCategoryList() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from category";
		List<Category> list = queryRunner.query(sql,new BeanListHandler<Category>(Category.class));
		return list;
	}
}

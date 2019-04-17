package com.shop.service;

import java.sql.SQLException;
import java.util.List;

import com.shop.dao.CategoryDao;
import com.shop.pojo.Category;

public class CategoryService {
	
	CategoryDao categoryDao = new CategoryDao();
	
	public List<Category> getCategoryList(){
		try {
			return categoryDao.getCategoryList();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

package com.shop.service;

import java.sql.SQLException;
import java.util.List;
import com.shop.dao.SearchDao;
import com.shop.pojo.Product;
public class SearchService {
	SearchDao searchDao = new SearchDao();
	public List<Product> search(String searchword){
		try { 
			List<Product> list = searchDao.search(searchword);
			for (Product product : list) {
				//关键字高亮显示
				String pname = product.getPname().replaceAll(searchword, "<font color='red'>"+searchword+"</font>");
				product.setPname(pname);
			}
			return list; 
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

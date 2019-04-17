package com.shop.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.shop.pojo.Product;
import com.shop.utils.C3P0Utils;
import com.shop.utils.PageBean;

public class ProductDao {
	/**
	 * 获取热门商品
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> getHotProduct() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where is_hot = ? limit ?,?";
		List<Product> productList = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),1,1,3);
		return productList;
	}
	/**
	 * 获得最新商品
	 * @return
	 * @throws SQLException
	 */
	public List<Product> getNewProduct() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product order by pdate desc limit ?,?"; 
		List<Product> productList = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),1,12);
		return productList;
	}
	/**
	 * 通过商品id查询商品详细信息
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Product getProductById(String id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid = ?"; 
		Product product = queryRunner.query(sql,new BeanHandler<Product>(Product.class),id);
		return product;
	}
	/**
	 * 根据分类id查询商品列表
	 * @param cid
	 * @return
	 */
	public List<Product> getProductListByCid(int cid,PageBean pageBean) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where cid = ? limit ?,?";
		List<Product> productList = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),cid,pageBean.getStart(),pageBean.getRows());
		return productList;
	}
	/**
	 * 
	 * @param cid
	 * @return
	 * @throws SQLException 
	 */
	public int getTotal(int cid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where cid = ?";
		List<Product> productList = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),cid);
		return productList.size();
	}
	
}

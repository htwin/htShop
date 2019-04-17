package com.shop.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.shop.pojo.User;
import com.shop.utils.C3P0Utils;

public class UserDao {
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */ 
	public User login(String username,String password) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from user where username = ? and password = ?";
		User user = queryRunner.query(sql,new BeanHandler<User>(User.class),username,password);
		return user;
	}

	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public boolean register(User user) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?)";
		int update = queryRunner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),
				user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode());
		return update>0?true:false;
	}
	/**
	 * 激活用户
	 * @param code
	 * @throws SQLException
	 */
	public void activeUser(String code) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="update user set state=1 where code=?";
		queryRunner.update(sql,code);
	}
}

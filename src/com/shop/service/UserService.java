package com.shop.service;

import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import com.shop.dao.UserDao;
import com.shop.pojo.User;
import com.shop.utils.MailUtils;

public class UserService {
	UserDao userDao = new UserDao();

	public User login(String username, String password) {
		try {
			return userDao.login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param user
	 * @return
	 */
	public boolean register(User user,HttpServletRequest request) {
		try {
			boolean success = userDao.register(user);
			//邮件标题
			String subject="来自ht商城的激活邮件！请点击以下链接激活账户！！";
			//邮箱内容
			String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
			String text =url+"/activeServlet?code="+user.getCode();
			//发送邮件
			MailUtils.sendMail("2285016799@qq.com",user.getEmail(),subject, text);
			return success;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (AddressException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 激活用户
	 * @param code
	 */
	public void activeUser(String code) {
		try {
			userDao.activeUser(code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

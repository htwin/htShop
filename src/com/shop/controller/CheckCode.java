package com.shop.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCode extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证码随机产生源
		String code = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		//随机生成6位校验码
		for(int i=0;i<6;i++) {
			int index = random.nextInt(code.length());
			sb.append(code.charAt(index));
		}
		String checkCode = sb.toString();
		//在内存中创建一副图像
		BufferedImage image = new BufferedImage(95, 35, BufferedImage.TYPE_INT_RGB);
		//得到图片
		Graphics g = image.getGraphics();
		//修改图片颜色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 95, 35); 
		//向图片写数据
		g.setColor(Color.BLUE);
		g.setFont(new Font(null,Font.HANGING_BASELINE,23));
		g.drawString(checkCode, 0,20); 
		//随机画出干扰线
		
		for(int i=0;i<10;i++) {
			g.setColor(new Color(random.nextInt(255),random.nextInt(255), random.nextInt(255)));
			int x1 = random.nextInt(85);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(85);
			int y2 = random.nextInt(30);
			g.drawLine(x1, y1, x2, y2);
		}
		//将验证码存入session
		request.getSession().setAttribute("realCheckCode",checkCode);
		
		//将图片写给浏览器
		ImageIO.write(image, "jpeg",response.getOutputStream());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

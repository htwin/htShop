package com.shop.utils;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class MailUtils {
	/**
	 * 发送邮件
	 * 
	 * @param form 发件人
	 * @param to   收件人
	 * @param subject 标题
	 * @param text 内容
	 * @throws MessagingException
	 * @throws AddressException
	 */
	public static void sendMail(String form, String to,String subject, String text) throws AddressException, MessagingException {
		Properties prop = new Properties();
		prop.put("mail.transport.protocol", "smtp");// 连接协议
		prop.put("mail.smtp.host", "smtp.qq.com");// 主机名
		prop.put("mail.smtp.port", 465);// 端口号
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
		prop.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
		// 创建session
		Session session = Session.getInstance(prop);

		// 创建邮件
		MimeMessage message = new MimeMessage(session);

		// 发件人邮箱地址
		message.setFrom(new InternetAddress(form));

		// 收件人邮箱地址
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

		// 邮件标题
		message.setSubject(subject);

		// 邮件内容
		message.setText(text);

		// 通过session得到transport对象
		Transport transport = session.getTransport();

		// 连接自己的邮箱账户
		transport.connect("2285016799@qq.com", "uvnkllzdaccndjbd");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码

		// 发送邮件
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();

	}
}

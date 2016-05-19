package com.lemon.common.email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.lemon.common.email.util.PropertyUtilityForEmail;
import com.lemon.util.HttpClient4;
import com.lemon.util.PropertyUtility;


public class EmailSend {

	/**
	 * hhc add 2016-05-10 18:55 
	 * 
	 * 发送邮件
	 */
	public void send( String subject, String text, String toEmail)throws MessagingException{
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "SMTP");
        props.put("mail.smtp.auth", "true");//同时通过验证 
        props.put("mail.debug", "true");

        props.put("mail.smtp.host", PropertyUtilityForEmail.getProperty("mail.host"));//存储发送邮件服务器的信息
        
        final String username = PropertyUtilityForEmail.getProperty("mail.server.username");
        final String password = PropertyUtilityForEmail.getProperty("mail.server.password");

        //使用验证
        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(username, password);
                    }
                });
        MimeMessage message = new MimeMessage(session);
        Address address = new InternetAddress(PropertyUtilityForEmail.getProperty("mail.server.username"));
        Address toAaddress = null ;
        if(null!=toEmail && !"".equals(toEmail)){
        	toAaddress = new InternetAddress(toEmail);
        	
        }else{
        	toAaddress = new InternetAddress(PropertyUtilityForEmail.getProperty("mail.to"));
        }
        
        
        message.setFrom(address);
        message.setRecipient(MimeMessage.RecipientType.TO, toAaddress);
        message.setSubject(subject);
        message.setText(text);
        message.setContent(text, "text/html;charset=UTF-8");
        message.setSentDate(new Date());

        Transport.send(message);
	}
	
	// 邮箱服务器
	private String host;
	// 这个是你的邮箱用户名
	private String username;
	// 你的邮箱密码
	private String password;
	private String personalName;
	private String mail_from;
	private String mail_to;
	private String subject;
	private String text;
	private int port;

	public EmailSend() {
	}

	public EmailSend(String host, int port, String username,
			String password, String mailto, String text, String subject,
			String personalName) {
		this.host = host;
		this.username = username;
		this.mail_from = username;
		this.password = password;
		this.mail_to = mailto;
		this.text = text;
		this.subject = subject;
		this.port = port;
		this.personalName = personalName;
	}

	/**
	 * 此段代码用来发送普通电子邮件
	 * 
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 * @throws UnsupportedEncodingException
	 */
	public void send() throws MessagingException, UnsupportedEncodingException {
		Map<String, String> pars = new HashMap<String, String>();
		pars.put("mail_to", mail_to);
		pars.put("subject", subject);
		pars.put("text", text);
		String postData =HttpClient4.doPost(PropertyUtility.getProperty("mail.url"),pars);
		System.out.println(postData);
		
	}

	/**
	 * 用来进行服务器对用户的认证
	 */
	public class Email_Autherticator extends Authenticator {
		public Email_Autherticator() {
			super();
		}

		public Email_Autherticator(String user, String pwd) {
			super();
			username = user;
			password = pwd;
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail_to() {
		return mail_to;
	}

	public void setMail_to(String mail_to) {
		this.mail_to = mail_to;
	}

	public String getMail_from() {
		return mail_from;
	}

	public void setMail_from(String mail_from) {
		this.mail_from = mail_from;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public static void main(String[] args) {
		/*
		 * EmailSendTool sendEmail = new EmailSendTool("smtp.163.com",
		 * "jeecms2012@163.com", "jeecms2012strong", "664592270@qq.com", "测试",
		 * "文本内容", "我", "", "");
		 */

		EmailSend sendEmail = new EmailSend("smtp.exmail.qq.com", 25,
				"ServerMail@asiafinance.cn", "asia@philips88",
				"rkwwj@163.com", "测试", "文本内容3", "wo");
		try {
			sendEmail.send();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}

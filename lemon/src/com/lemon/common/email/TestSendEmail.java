package com.lemon.common.email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.lemon.common.email.util.PropertyUtilityForEmail;

public class TestSendEmail {

	public void send( String subject, String text)throws MessagingException{
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
        Address toAaddress = new InternetAddress(PropertyUtilityForEmail.getProperty("mail.to"));
        
        message.setFrom(address);
        message.setRecipient(MimeMessage.RecipientType.TO, toAaddress);
        message.setSubject(subject);
        message.setText(text);
        message.setContent(text, "text/html;charset=UTF-8");
        message.setSentDate(new Date());

        Transport.send(message);
        System.out.println("邮件发送！");
	}
	public static void main(String[] args) throws MessagingException, UnsupportedEncodingException{
		TestSendEmail hsm = new TestSendEmail();
		try {
			hsm.send( "测试标题", "测试内容");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}

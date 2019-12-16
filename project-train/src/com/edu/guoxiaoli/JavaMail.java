package com.edu.guoxiaoli;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.utils.ReadProperties;


@Listeners({ com.edu.guoxiaoli.JMailListener.class})
public class JavaMail {
//	String from="guoxiaoligxl@126.com";
//	String auth_code="gxl100624";
//	String to="3186242938@qq.com";
//String result
  @Test
  public void sendMail(String result) throws IOException {
//	  1.创建Properties对象
	  Properties pro=new  Properties();
	//读取配置文件
	  String from=ReadProperties.getPropertyValue("from_mail");
	  String auth_code=ReadProperties.getPropertyValue("auth_code");
	  String to=ReadProperties.getPropertyValue("to_mail");
	  pro.put("mail.transport.protocol", "smtp");
	  pro.put("mail.smtp.host", "smtp.126.com");
	  pro.put("mail.smtp.auth", true);
//	  2.session对象
	  Session session=Session.getInstance(pro,new Authenticator(){
		  protected PasswordAuthentication getPasswordAuthentication(){
			  return new PasswordAuthentication(from,auth_code);
		  }
	  });
//	  3.Message对象设置，发件人，收件人，主题，正文
	  Message message=new MimeMessage(session); 
	  try {
		  message.setFrom(new InternetAddress(from));
		  message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		  message.setSubject("hello world");
		  message.setText(result);
//		  4.使用Transport发送
		  Transport.send(message);
	  } catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
  }
}


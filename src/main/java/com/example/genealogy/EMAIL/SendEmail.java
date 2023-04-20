package com.example.genealogy.EMAIL;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail extends Thread {
    // 收件人电子邮箱
    String ToEmail = null;
    String username = null;
    // 发件人电子邮箱
    String FromEmail = "xsl203457@163.com";
    // 指定发送邮件的主机为 smtp.163.com
    String host = "smtp.163.com";
    public SendEmail(String ToEmail) throws MessagingException {
        this.ToEmail = ToEmail;
    }

    public SendEmail(String ToEmail, String username) throws MessagingException {
        this.ToEmail = ToEmail;
        this.username=username;
    }

     public void run()  {

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("xsl203457@163.com", "SHEPYSMVLYPLFPXX"); //发件人邮件用户名、密码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(FromEmail));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));

            // Set Subject: 头部头字段
            message.setSubject("注册激活邮件");
            String url = "http://localhost:8080/Genealogy_war/Active?email="+ToEmail;

            String content = username+ "(" + ToEmail + "),您好<br/>感谢您注册  !<br/>"
                    + "<b>验证您的邮箱地址注册</b><br/>请点击下面的链接来确认您的注册<br/>"
                    + "<a href='" + url + "'>确认!请点击这里验证此邮件</a><br/>"
                    + "如果您不能点击上述标签为“确认！”的链接，您还可以通过复制（或输入）下面的URL到地址栏中来验证您的邮件地址。"
                    + "<a href='" + url + "'>" + url + "</a><br/>"
                    + "如果您认为这是垃圾邮件，请忽略此邮件。";
            // 设置消息体
            message.setContent(content, "text/html;charset=utf-8");
            // 发送消息
            Transport.send(message);

            System.out.println("Sent message successfully....from run");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public static void main(String[] args) throws MessagingException {
        SendEmail sendEmail = new SendEmail("xsl2034576972@gmail.com","ximeng");
        //System.out.println(sendEmail.sendemail());

    }

}
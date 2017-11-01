package com.serviceImpl.www;
import com.domain.www.Auth;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Administrator on 2017/11/1.
 *
 * mailusername=13063310938@163.com
 mailpassword=Ckj2352400400??!
 mailname=googlecode
 smtphost=smtp.163.com
 port=25
 */

public class EmailSend {
    // 一个服务器会话   根据配置信息确认的会话
    private Session session;
    private Properties properties;

    //配置邮件对象
   private MimeMessage mimeMessage;
    public EmailSend(String mailusername, String mailpassword, String smtphost, String port) {

        properties = System.getProperties();
        properties.put("mail.smtp.host", smtphost);
        properties.put("mail.smtp.port", port);

        //构建auth对象
        Auth auth = new Auth(mailusername, mailpassword);
        //第三方认证授权
        properties.put("mail.smtp.auth", "true");
       // 构建session对象
        session = Session.getInstance(properties,auth);
    }

    //核心 ---发送邮件
    //  参数： 发件人 收件人 主题 内容
    public boolean sendEmail(String mailusername, String email, String them, String content) {
        mimeMessage = new MimeMessage(session);
        System.out.println("mimeMessage"+"A");
        try {
            //设置邮件发送者
            mimeMessage.setFrom(mailusername);
            System.out.println("mimeMessage"+"B");
            if (email != null) {
                //设置邮件接收者
                System.out.println("mimeMessage"+"C");
                mimeMessage.setRecipients(MimeMessage.RecipientType.TO, email);
            }
            //设置主题
            mimeMessage.setSubject(them, "utf-8");
            //设置内容
            mimeMessage.setContent(content,"text/html;charset=UTF-8");
            System.out.println("mimeMessage"+"D");
            //发送邮件
            Transport.send(mimeMessage);
            System.out.println("mimeMessage"+"E");
            //成功

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;

    }




}

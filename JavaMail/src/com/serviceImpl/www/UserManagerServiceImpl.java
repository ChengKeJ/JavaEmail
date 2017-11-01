package com.serviceImpl.www;

import com.com.daoImpl.www.UserManagerImpl;
import com.domain.www.User;
import com.service.www.UserManagerService;
import com.util.www.UUIDutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2017/11/1.
 */
public class UserManagerServiceImpl  implements UserManagerService{
    @Override
    public boolean registerUser(String username, String password, String email) {
        //构建对象一遍调用dao
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);
        String uuid = UUIDutil.getUUID();
        user.setUuid(uuid);
        UserManagerImpl userManager = new UserManagerImpl();
        int i = userManager.saveUser(user);
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("D:\\IDEA\\JAVAEE\\JavaMail\\src\\info.properties")));
            //读取配置文件
            String mailusername = (String) properties.getProperty("mailusername");
            String  mailpassword = (String) properties.getProperty("mailpassword");
            String mailname = (String) properties.getProperty("mailname");
            String googlecode = (String) properties.getProperty("googlecode");
            String smtphost = (String) properties.getProperty("smtphost");
            String port = (String) properties.getProperty("port");
            //构建邮件主题
            String them = "激活账号";
            //构建邮件的内容    本质是html
            String content = "<html ><body><h1>请尊敬的用户"+username+"，你好呀，请点击下面的链接进行完成注册,感谢你的合作!</h1>" +
                    "<a href='http://localhost:8080/JavaMail/activeServlet?uuid="+uuid+"'>" +
                            "http://localhost:8080/JavaMail/activeServlet?uuid="+uuid+"</a>" +
                    "</body>" + "</html>";

            //构建邮件发送对象
            System.out.println("构建邮件发送对象");
            EmailSend emailSend = new EmailSend(mailusername,mailpassword,smtphost,port);

            System.out.println("VVVV");
            System.out.println(emailSend);
            boolean b = emailSend.sendEmail(mailusername, email, them, content);
            System.out.println(b);

            if (b) {
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean activeUser(String uuid) {
        UserManagerImpl userManager = new UserManagerImpl();
        User user = new User();
        user.setUuid(uuid);
        user.setState(1);
        int i = userManager.activeUser(user);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }
}

package com.domain.www;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by Administrator on 2017/11/1.
 */
public class Auth  extends Authenticator {
    //实现一个接口

    private String username;
    private String password;

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
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
//用来底层传输用户名密码  是去和smtp交互的
    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}

package com.service.www;

import com.domain.www.User;

/**
 * Created by Administrator on 2017/11/1.
 */
public interface UserManagerService {


    public abstract boolean registerUser(String username,String password,String email);


    public abstract boolean activeUser(String uuid);




}

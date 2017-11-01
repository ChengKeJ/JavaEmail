package com.dao.www;

import com.domain.www.User;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface UserManager {
    public abstract int saveUser(User user);
    public abstract int activeUser(User user);


}

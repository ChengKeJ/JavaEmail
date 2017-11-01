package com.serviceImpl.www;

import com.service.www.MailCheck;

/**
 * Created by Administrator on 2017/10/31.
 */
public class MailCheckImp implements MailCheck {

    @Override
    public boolean checkEmail(String email) {
        //邮箱的合法性验证

        if (email.matches("[\\w!#$%&'*+/=?^_`{|}~-]+" +
                "(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")) {

            return true;
        }

        return false;
    }
}

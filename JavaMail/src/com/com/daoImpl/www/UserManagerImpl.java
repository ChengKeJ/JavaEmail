package com.com.daoImpl.www;

import com.dao.www.UserManager;
import com.domain.www.User;
import com.util.www.druiddemo;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/11/1.
 */
public class UserManagerImpl implements UserManager {

    Connection connection = druiddemo.getConnection();

    @Override
    public int saveUser(User user) {

        String sql = "insert into usermail(username,password,email,state,uuid) values(?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner();
        int update = 0;
        try {
            update = queryRunner.update(connection, sql, user.getName(),
                    user.getPassword(),user.getEmail(),user.getState(),user.getUuid());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int activeUser(User user) {
        String sql = "update usermail set state=? where uuid=?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            int update = queryRunner.update(connection, sql, user.getState(),
                    user.getUuid());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}

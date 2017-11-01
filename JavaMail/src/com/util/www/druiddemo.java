package com.util.www;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2017/10/31.
 * 德鲁伊
 */
public class druiddemo {

   public static  DataSource dataSource =null;
    static {
        Properties properties = new Properties();
        try {
            //加载配置文件
            properties.load(new FileInputStream(new File("D:\\IDEA\\JAVAEE\\Jdbc\\src\\druid.properties")));
            //获取数据源
          dataSource = DruidDataSourceFactory.createDataSource(properties);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  static Connection getConnection() {
        Connection connection=null;
        try {
           connection= dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }



}

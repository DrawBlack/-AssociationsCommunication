package com.fancy.DBUtils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import static com.fancy.DBUtils.DataBaseProfile.*;

/**
 * Created by Jackie on 2017/1/31.
 *
 */

@Component
public class ConnectionImpl implements ConnectionPool , InitializingBean{

    private List<ProxyConnection> busyConnections = new LinkedList<>();

    private List<ProxyConnection> freeConnections = new LinkedList<>();

    private static Logger logger = Logger.getLogger(ConnectionImpl.class.getName());

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.warning("加载驱动时没找到驱动相关的Jar包");
        }
    }


    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public Connection getConnection(String usename, String password) {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try{
            for (int i = 0 ; i < maxConnections ; i++){
                freeConnections.add(DriverManager.getConnection(url , usename , password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warning("DriverManager得到Connection时出现异常，可能是密码用户名或者数据库名不正确");
        }
    }
}

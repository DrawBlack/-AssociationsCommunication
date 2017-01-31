package com.fancy.DBUtils;

import java.sql.Connection;

/**
 * Created by Jackie on 2017/1/31.
 *
 */


public interface ConnectionPool {

    Connection getConnection();

    Connection getConnection(String usename , String password);

}

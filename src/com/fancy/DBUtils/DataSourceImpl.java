package com.fancy.DBUtils;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.ConnectionEvent;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Created by Jackie on 2017/1/31.
 *
 */

public class DataSourceImpl implements DataSource {

    private ConnectionPool connectionPool = new ConnectionPoolImpl();

    @Override
    public Connection getConnection() throws SQLException {
        return connectionPool.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return connectionPool.getConnection();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public static void main(String[] args){
        DataSourceImpl dataSource = new DataSourceImpl();

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connection.hashCode();
    }
}

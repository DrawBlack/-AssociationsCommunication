package com.fancy.DBUtils;

import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Jackie on 2017/2/1.
 * 自定义数据库连接池
 */
public class MyDataSourceFactory implements DataSourceFactory {

    private String username ;

    private String password ;

    private String url ;

    private String driver ;

    private int macConnectionCountSize ;

    @Override
    public void setProperties(Properties properties) {
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String drive = properties.getProperty("driver");
        String maxConnectionCountString = properties.getProperty("size");
        int maxConnectionCount = 0;
        if (maxConnectionCountString != null)
            maxConnectionCount = Integer.parseInt(maxConnectionCountString);

        if (username == null || password == null || url == null || drive == null)
            throw new IllegalProerties();

    }

    @Override
    public DataSource getDataSource() {
        System.out.print("lalala");
        return null;
    }
}

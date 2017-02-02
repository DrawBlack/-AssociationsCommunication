package com.fancy.DBUtils;

import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Jackie on 2017/2/1.
 * 自定义数据库连接池
 */
public class MyDataSourceFactory implements DataSourceFactory {

    @Override
    public void setProperties(Properties properties) {
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String drive = properties.getProperty("driver");

        DBProfile.setUsername(username);
        DBProfile.setPassword(password);
        DBProfile.setUrl(url);
        DBProfile.setDrive(drive);

        System.out.print(drive);
    }

    @Override
    public DataSource getDataSource() {
        System.out.print("lalala");
        return new DataSourceImpl();
    }
}

package com.fancy.DBUtils;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;

/**
 * Created by Jackie on 2017/1/31.
 *
 */
public class ConnectionImpl implements ConnectionPool {

    @Autowired
    private DataBaseProfile dataBaseProfile ;

    /**
     * init profile
     */
    static {

    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public Connection getConnection(String usename, String password) {
        return null;
    }

    public void setDataBaseProfile(DataBaseProfile dataBaseProfile) {
        this.dataBaseProfile = dataBaseProfile;
    }

    public DataBaseProfile getDataBaseProfile() {
        return dataBaseProfile;
    }
}

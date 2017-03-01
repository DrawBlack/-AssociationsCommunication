package com.fancy.DBUtils;

/**
 * Created by Jackie on 2017/2/2.
 *
 */
public class DBProfile {

    private  String username ;

    private  String password ;

    private String url ;

    private  String driver ;

    private int maxConnectionCount ;

    public int getMaxConnectionCount() {
        return maxConnectionCount;
    }

    public  String getUsername() {
        return username;
    }

    public  String getPassword() {
        return password;
    }

    public  String getUrl() {
        return url;
    }

    public  String getDriver() {
        return driver;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setMaxConnectionCount(int maxConnectionCount) {
        this.maxConnectionCount = maxConnectionCount;
    }
}

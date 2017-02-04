package com.fancy.DBUtils;

/**
 * Created by Jackie on 2017/2/2.
 *
 */
public class DBProfile {

    private static String username ;

    private static String password ;

    private static String url ;

    private static String driver ;

    public static int maxConnectionCount ;

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUrl() {
        return url;
    }

    public static String getDriver() {
        return driver;
    }

    public static void setUsername(String username) {
        DBProfile.username = username;
    }

    public static void setPassword(String password) {
        DBProfile.password = password;
    }

    public static void setUrl(String url) {
        DBProfile.url = url;
    }

    public static int getMaxConnectionCount() {
        return maxConnectionCount;
    }

    public static void setDriver(String driver) {
        DBProfile.driver = driver;
    }

    public static void setMaxConnectionCount(int maxConnectionCount) {
        DBProfile.maxConnectionCount = maxConnectionCount;
    }
}

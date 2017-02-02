package com.fancy.DBUtils;

/**
 * Created by Jackie on 2017/2/2.
 */
public class DBProfile {

    public static String username ;

    public static String password ;

    public static String url ;

    public static String driver ;

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

    public static void setDrive(String drive) {
        DBProfile.driver = drive;
    }
}

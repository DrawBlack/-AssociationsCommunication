package com.fancy.DBUtils;

import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 * Created by Jackie on 2017/1/31.
 *
 */


public class ConnectionPoolImpl implements ConnectionPool{

    private int freeConnCount = 20;

    private String username = DBProfile.getUsername();

    private String password = DBProfile.getPassword();

    private String url = DBProfile.getUrl();

    private String driver = DBProfile.getDriver();

    private int maxConnections = 20 ;

    private List<ProxyConnection> busyConnections = new ArrayList<>();

    private List<ProxyConnection> freeConnections = new ArrayList<>();

    private static Logger logger = Logger.getLogger(ConnectionPoolImpl.class.getName());

    public ConnectionPoolImpl(){

        try {
            initConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void initConnection() throws SQLException{
        try{
            //加载MySql的驱动类
            Class.forName(driver) ;
        }catch(ClassNotFoundException e){
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace() ;
        }

        for (int i = 0 ; i < maxConnections ; i ++){
            ProxyConnection proxyConnection = new ProxyConnection( DriverManager.getConnection( url , username , password ) , this);
            freeConnections.add(proxyConnection);
        }

    }



    @Override
    public synchronized Connection getConnection() {

        Connection connection = null ;

        if (freeConnCount > 0){
            ProxyConnection proxyConnection = freeConnections.remove(--freeConnCount);
            proxyConnection.setLastUsedTime(System.currentTimeMillis());
            connection = proxyConnection.getProxyConnection();
            busyConnections.add(proxyConnection);
        }else {
            try {
                connection = newConnetion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return connection;
    }

    @Override
    public synchronized Connection getConnection(String username, String password) {
        return getConnection();
    }

    public void backConnection(ProxyConnection proxyConnection) throws IndexOutOfBoundsException{
        int index = busyConnections.indexOf(proxyConnection);
        if (index > 0){
            busyConnections.remove(index);
            freeConnections.add(proxyConnection);
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    private Connection newConnetion() throws SQLException {
        return DriverManager.getConnection( "jdbc:mysql://localhost:3306/book" , "root" , "123" ) ;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getDrive() {
        return driver;
    }

    public int getMaxConnections() {
        return maxConnections;
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

    public void setDrive(String drive) {
        this.driver = drive;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }
}

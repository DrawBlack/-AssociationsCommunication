package com.fancy.DBUtils;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * Created by Jackie on 2017/1/31.
 *
 */

public class ProxyConnection implements InvocationHandler {

    private final String CLOSE = "close" ;

    private static final Class<?>[] IFACES = new Class[]{Connection.class};

    private Connection realConnection ;

    private Connection proxyConnection ;

    private long createTime ;

    private long lastUsedTime ;

    private int hashCode ;

    private boolean valid ;

    private ConnectionPoolImpl connectionPool ;

    public ProxyConnection(Connection connection , ConnectionPoolImpl connectionPool ){
        this.hashCode = connection.hashCode();
        this.realConnection = connection;
        this.valid = true ;
        this.connectionPool = connectionPool;
        this.proxyConnection = (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader() , IFACES , this);
        //this.proxyConnection = connection;
        this.createTime = System.currentTimeMillis();
        this.lastUsedTime = 0;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (CLOSE.hashCode() == methodName.hashCode() && CLOSE.equals(methodName)){
            connectionPool.backConnection(this);
            return null;
        }else {
            return method.invoke(realConnection, args);
        }
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        ProxyConnection proxyConnection = (ProxyConnection) obj;
        Connection connection = proxyConnection.getRealConnection();
        if (connection.hashCode() == hashCode)
            return true;
        else
            return false;
    }

    public boolean isValid(){
        return valid;
    }

    public void invalided(){
        valid = false;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public void setLastUsedTime(long lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Connection getRealConnection() {
        return realConnection;
    }

    public Connection getProxyConnection() {
        return proxyConnection;
    }

    public long getCreateTime() {
        return createTime;
    }

    public long getLastUsedTime() {
        return lastUsedTime;
    }

    public int getHashCode() {
        return hashCode;
    }

    public ConnectionPoolImpl getConnectionPool() {
        return connectionPool;
    }

    public void setConnectionPool(ConnectionPoolImpl connectionPool) {
        this.connectionPool = connectionPool;
    }

    public static void main(String[] args){


    }

}

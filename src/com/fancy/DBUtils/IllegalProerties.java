package com.fancy.DBUtils;

/**
 * Created by Jackie on 2017/2/3.
 */
public class IllegalProerties extends RuntimeException {

    private static String message = "username password url driver is not allowd null";

    public IllegalProerties(){
        super(message);
    }

}

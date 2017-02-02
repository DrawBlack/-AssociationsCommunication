package com.fancy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Jackie on 2017/1/31.
 *
 */
public class SpringContext {

    public static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration.class);

}

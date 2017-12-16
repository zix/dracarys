package org.dracarys.demo.client.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationClient {
    public static final int PORT = 13900;

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "classpath:conf/spring/app-client-config.xml" });
        ((ConfigurableApplicationContext)ctx).close();
    }
}

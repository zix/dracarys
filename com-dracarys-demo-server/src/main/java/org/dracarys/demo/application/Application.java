package org.dracarys.demo.application;

import java.util.Map;

import org.dracarys.commons.annotation.Service;
import org.dracarys.commons.impl.netty.server.NettyServer;
import org.dracarys.commons.impl.server.ServiceManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static final int PORT = 13900;

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "classpath:conf/spring/app-config.xml" });
        Map<String, Object> beansWithAnnotation = ctx.getBeansWithAnnotation(Service.class);

        ServiceManager.init(beansWithAnnotation.values());
        new NettyServer().bind(PORT);
    }
}

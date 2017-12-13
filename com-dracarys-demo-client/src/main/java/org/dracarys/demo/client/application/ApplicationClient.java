package org.dracarys.demo.client.application;

import java.util.Map;
import java.util.Set;

import org.dracarys.commons.annotation.Service;
import org.dracarys.commons.impl.client.SimpleServiceFactory;
import org.dracarys.commons.impl.netty.server.NettyServer;
import org.dracarys.commons.impl.server.ServiceManager;
import org.dracarys.demo.api.IServerInfo;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class ApplicationClient {
    public static final int PORT = 13900;

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "classpath:conf/spring/app-client-config.xml" });
    }
}

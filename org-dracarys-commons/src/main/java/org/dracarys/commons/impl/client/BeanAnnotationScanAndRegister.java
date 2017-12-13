/*
 * Copyright (C), 2013-2017, 上海赛可电子商务有限公司
 * FileName: BeanAnnotationScanAndRegister.java
 * Author:   chenliang
 * Date:     2017年12月13日 上午10:55:20
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.commons.impl.client;

import java.util.Set;

import org.dracarys.commons.annotation.Service;
import org.dracarys.commons.constant.NettyConsts;
import org.dracarys.commons.impl.netty.client.NettyClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * 扫描org.dracarys.commons.annotation.Service.Service.class注释的接口，并实例化代理类后注册至Spring的ApplicationContext<br> 
 *
 * @author chenliang
 */
public class BeanAnnotationScanAndRegister implements ApplicationContextAware {
    /** 记录日志. */
    private static final Logger LOGGER = LoggerFactory.getLogger(NettyClientHandler.class);
    
    /** 服务端ip, 默认本地 */
    private String host = NettyConsts.IP;
    
    /** 服务端port, 默认13900 */
    private int port = NettyConsts.PORT;
    
    /** 扫描包路径, 默认全部 */
    private String scanPackage = "";
    
    /** 
     * {@inheritDoc}}
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ClassPathScanningCandidateComponentProvider scanner = new AnnotationComponentProvider();
        scanner.addIncludeFilter(new AnnotationTypeFilter(Service.class));
        SimpleServiceFactory server = new SimpleServiceFactory(this.host, this.port);
        Set<BeanDefinition> Components = scanner.findCandidateComponents(this.scanPackage);
        for (BeanDefinition beanDefinition : Components) {
            String beanClassName = beanDefinition.getBeanClassName();
            
            ConfigurableListableBeanFactory beanFactory = ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
            Class<?> clazz = null;
            try {
                clazz = Class.forName(beanClassName);
            } catch (ClassNotFoundException e) {
                LOGGER.error("error:", e);
            }
            beanFactory.registerSingleton(beanDefinition.getBeanClassName(), server.getService(clazz));
        }
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the scanPackage
     */
    public String getScanPackage() {
        return scanPackage;
    }

    /**
     * @param scanPackage the scanPackage to set
     */
    public void setScanPackage(String scanPackage) {
        this.scanPackage = scanPackage;
    }
    
}

/*
 * Copyright (C), 2013-2017, 上海赛可电子商务有限公司
 * FileName: SimpleServiceFactory.java
 * Author:   chenliang
 * Date:     2017年12月5日 下午3:40:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.commons.impl.client;

import java.lang.reflect.Proxy;

import org.dracarys.commons.constant.NettyConsts;

/**
 * 客户端服务获取工厂.<br>
 *
 * @author chenliang
 */
public class SimpleServiceFactory implements ServiceFactory {
    private String host = NettyConsts.IP;
    private int port = NettyConsts.PORT;

    public SimpleServiceFactory() {
    }
    
    public SimpleServiceFactory(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public <T> T getService(Class<T> clazz) {
        return (T) this.getProxy(clazz);
    }

    /**
     * 获取代理对象.
     *
     * @param clazz the clazz
     * @return 代理对象
     */
    private Object getProxy(Class<?> clazz) {
        Class<?>[] classes;
        if (clazz.isInterface()) {
            classes = new Class[] { clazz };
        } else {
            classes = clazz.getInterfaces();
        }
        return getProxy(classes);
    }

    /**
     * 获取代理对象.
     *
     * @param classes the classes
     * @return 代理对象
     */
    private Object getProxy(Class<?>[] classes) {
        ServiceProxyHandler serviceProxyHandler = new ServiceProxyHandler();
        serviceProxyHandler.setHost(host);
        serviceProxyHandler.setPort(port);
        return Proxy.newProxyInstance(ServiceProxyHandler.class.getClassLoader(), classes, serviceProxyHandler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T getService(String name, Class<T> t) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }
}

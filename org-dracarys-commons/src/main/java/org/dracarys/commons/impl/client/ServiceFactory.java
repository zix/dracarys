/*
 * Copyright (C), 2013-2017, 上海赛可电子商务有限公司
 * FileName: ServiceFactory.java
 * Author:   chenliang
 * Date:     2017年12月5日 下午5:07:46
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.commons.impl.client;

/**
 * 客户端服务工厂<br> .
 *
 * @author chenliang
 */
public interface ServiceFactory {
    
    /**
     * 功能描述: <br>
     * 根据类型获取代理对象.
     *
     * @param <T> the generic type
     * @param t the t
     * @return the service
     */
    public <T> T getService(Class<T> t);
    
    /**
     * 功能描述: <br>
     * 根据类型及名称获取代理对象.
     *
     * @param <T> the generic type
     * @param name the name
     * @param t the t
     * @return the service
     */
    public <T> T getService(String name,Class<T> t);

    /**
     * 功能描述: <br>
     * 工厂销毁.
     */
    public void destroy();
}

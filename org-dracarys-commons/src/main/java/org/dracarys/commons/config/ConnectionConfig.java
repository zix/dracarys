/*
 * Copyright (C), 2013-2017, 上海赛可电子商务有限公司
 * FileName: ConnectionConfig.java
 * Author:   chenliang
 * Date:     2017年11月22日 下午4:55:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.commons.config;

/**
 * 服務端配置<br> 
 *
 * @author chenliang
 */
public class ConnectionConfig {
    
    /** The ip. */
    private final String ip;
    
    /** The port. */
    private final String port;
    
    /**
     * Instantiates a new connection config.
     *
     * @param ip the ip
     * @param port the port
     */
    ConnectionConfig(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    /**
     * Gets the ip.
     *
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Gets the port.
     *
     * @return the port
     */
    public String getPort() {
        return port;
    }
    
    
}

/*
 * Copyright (C), 2013-2017
 * FileName: ServerInfoImplTest.java
 * Author:   ZIX
 * Date:     2017年12月12日 上午10:41:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.demo.client.service.impl;

import org.dracarys.demo.api.IServerInfo;
import org.dracarys.demo.client.config.BaseTestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author chenliang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ServerInfoImplBeanTest extends BaseTestConfig {
    @Autowired
    IServerInfo iServerInfo;
    
    /**
     * Test method for {@link org.dracarys.demo.service.impl.ServerInfoImpl#getServerInfo()}.
     */
    @Test
    public final void testGetServerInfo() throws Exception {
        String serverInfo = iServerInfo.getServerInfo();
        LOGGER.info("=>"+JSONObject.toJSONString(serverInfo));
    }

    /**
     * Test method for {@link org.dracarys.demo.service.impl.ServerInfoImpl#getServerInfo(java.lang.String)}.
     */
    @Test
    public final void testGetServerInfoString() throws Exception {
        LOGGER.info("=>"+iServerInfo.getServerInfoByPropName("os.name"));
        LOGGER.info("=>"+iServerInfo.getServerInfoByPropName("java.vm.vendor"));
    }
    
}

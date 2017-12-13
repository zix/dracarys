/*
 * Copyright (C), 2013-2017, 上海赛可电子商务有限公司
 * FileName: ServerInfoImplTest.java
 * Author:   chenliang
 * Date:     2017年12月12日 上午10:41:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.demo.client.service.impl;

import org.dracarys.commons.impl.client.SimpleServiceFactory;
import org.dracarys.demo.api.IServerInfo;
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
public class ServerInfoImplTest {
    SimpleServiceFactory local = new SimpleServiceFactory("127.0.0.1", 13900);
    SimpleServiceFactory server = new SimpleServiceFactory("10.32.172.121", 13900);

    /**
     * Test method for {@link org.dracarys.demo.service.impl.ServerInfoImpl#getServerInfo()}.
     */
    @Test
    public final void testGetServerInfo() throws Exception {
        IServerInfo service = local.getService(IServerInfo.class);
        String serverInfo = service.getServerInfo();
        System.out.println(JSONObject.toJSONString(serverInfo));
    }

    /**
     * Test method for {@link org.dracarys.demo.service.impl.ServerInfoImpl#getServerInfo(java.lang.String)}.
     */
    @Test
    public final void testGetServerInfoString() throws Exception {
        IServerInfo service = local.getService(IServerInfo.class);
        System.out.println(service.getServerInfoByPropName("os.name"));
        System.out.println(service.getServerInfoByPropName("java.vm.vendor"));
    }

    
}

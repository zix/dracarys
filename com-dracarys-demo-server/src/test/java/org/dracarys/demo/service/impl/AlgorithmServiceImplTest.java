/*
 * Copyright (C), 2013-2017, 上海赛可电子商务有限公司
 * FileName: AlgorithmServiceImplTest.java
 * Author:   chenliang
 * Date:     2017年12月8日 下午1:50:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.demo.service.impl;

import org.dracarys.commons.impl.client.SimpleServiceFactory;
import org.dracarys.demo.api.IAlgorithmService;
import org.dracarys.demo.vo.Bounce;
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
public class AlgorithmServiceImplTest {

    /**
     * Test method for {@link org.dracarys.demo.service.impl.AlgorithmServiceImpl#bounceCount(int, int)}.
     */
    @Test
    public final void testBounceCount() throws Exception {
        SimpleServiceFactory simpleServiceFactory = new SimpleServiceFactory();
        IAlgorithmService service = simpleServiceFactory.getService(IAlgorithmService.class);
        Bounce bounceCount = service.bounceCount(1000, 10);
        System.out.println(JSONObject.toJSONString(bounceCount));
    }

}

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
package org.dracarys.demo.client.service.impl;

import java.util.List;

import org.dracarys.demo.api.IAlgorithmService;
import org.dracarys.demo.client.config.BaseTestConfig;
import org.dracarys.demo.vo.Bounce;
import org.dracarys.demo.vo.Profit;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author chenliang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AlgorithmServiceImplBeanTest extends BaseTestConfig {
    @Autowired
    IAlgorithmService iAlgorithmService;

    /**
     * Test method for {@link org.dracarys.demo.service.impl.AlgorithmServiceImpl#bounceCount(int, int)}.
     */
    @Test
    public final void testBounceCount() throws Exception {
        Bounce bounceCount = iAlgorithmService.bounceCount(1000, 10);
        LOGGER.info("=>"+JSONObject.toJSONString(bounceCount));
    }

    @Test
    public final void testBoseraFundB() throws Exception {
        List<Profit> profitJson = iAlgorithmService.boseraFundB(1000000.0, 0.045, 10);
        LOGGER.info("=>"+JSONObject.toJSONString(profitJson));
        List<Profit> profits = JSONObject.parseObject(JSONObject.toJSONString(profitJson), new TypeReference<List<Profit>>(){});
        for (Profit profit : profits) {
            LOGGER.info("第"+profit.getYear()+"年余额："+profit.getGain().longValue()+"，每年增额："+profit.getGainIncrement().longValue());
        }
    }
    
}

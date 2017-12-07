/*
 * Copyright (C), 2013-2017, 上海赛可电子商务有限公司
 * FileName: SimpleServiceFactoryTest.java
 * Author:   chenliang
 * Date:     2017年12月5日 下午4:34:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.commons.impl.client;

import java.util.Date;

import org.dracarys.demo.api.IBrandService;
import org.dracarys.demo.vo.Brand;
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
public class SimpleServiceFactoryTest {

    /**
     * Test method for {@link org.dracarys.commons.impl.client.SimpleServiceFactory#getService(java.lang.Class)}.
     */
    @Test
    public final void testGetService() throws Exception {
        SimpleServiceFactory simpleServiceFactory = new SimpleServiceFactory();
        IBrandService service = simpleServiceFactory.getService(IBrandService.class);
        Brand brand = new Brand();
        brand.setBrandId(1L);
        brand.setBrandName("BrandName");
        brand.setBrandEnName("BrandEnName");
        brand.setCreateUser("白龙吟");
        brand.setCreateTime(new Date());
        brand = service.createBrand(brand, 1L, "韩跳跳");
        System.out.println("=>"+JSONObject.toJSONString(brand));
    }

}

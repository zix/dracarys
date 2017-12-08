/*
 * Copyright (C), 2013-2017, 上海赛可电子商务有限公司
 * FileName: AlgorithmServiceImpl.java
 * Author:   chenliang
 * Date:     2017年12月8日 下午1:42:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.demo.service.impl;

import org.dracarys.demo.api.IAlgorithmService;
import org.dracarys.demo.vo.Bounce;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author chenliang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class AlgorithmServiceImpl implements IAlgorithmService {

    /**
     * {@inheritDoc}
     */
    @Override
    public Bounce bounceCount(int height, int count) {
        int c = 0;
        int h = height;
        for (int i = 1; i <= count; i++) {
            c += h;
            h = h / 2;
        }
        Bounce bounce = new Bounce();
        bounce.setHeight(h);
        bounce.setCount(c);
        return bounce;
    }

}

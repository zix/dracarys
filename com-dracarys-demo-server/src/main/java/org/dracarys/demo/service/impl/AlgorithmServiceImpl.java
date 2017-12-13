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

import java.util.ArrayList;
import java.util.List;

import org.dracarys.demo.api.IAlgorithmService;
import org.dracarys.demo.vo.Bounce;
import org.dracarys.demo.vo.Profit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(AlgorithmServiceImpl.class);

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

    /** 
     * {@inheritDoc}}
     * @see org.dracarys.demo.api.IAlgorithmService#boseraFundB(java.lang.Double, java.lang.Double, int)
     */
    @Override
    public List<Profit> boseraFundB(Double cost, Double rate, int yearCount) {
        LOGGER.info("参数: {}, {}, {}", cost, rate, yearCount);
        Double total = cost;
        List<Profit>  profits = new ArrayList<>();
        for (int i = 1; i <= yearCount; i++) {
            Double old = total;
            total += total * rate;
            Double incr = total-old;
            Profit profit = new Profit();
            profit.setYear(i);
            profit.setGain(total);
            profit.setGainIncrement(incr);
            profits.add(profit);
        }
        return profits;
    }

}

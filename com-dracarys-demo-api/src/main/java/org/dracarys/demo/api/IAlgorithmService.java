/*
 * Copyright (C), 2013-2017, 上海赛可电子商务有限公司
 * FileName: AlgorithmService.java
 * Author:   chenliang
 * Date:     2017年12月8日 下午1:13:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.demo.api;

import java.util.List;

import org.dracarys.commons.annotation.EndPoint;
import org.dracarys.commons.annotation.Param;
import org.dracarys.commons.annotation.Service;
import org.dracarys.demo.vo.Bounce;
import org.dracarys.demo.vo.Profit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author chenliang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("demo.algorithmService")
public interface IAlgorithmService {
    /**
     * 功能描述: <br>
     * 一球从height米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第count次落地时，共经过多少米？第count次反弹多高？
     *
     * @param height
     * @param count
     * @return
     */
    @EndPoint("bounceCount")
    Bounce bounceCount(@Param("height") int height, @Param("count") int count);
    
    @EndPoint("boseraFundB")
    List<Profit> boseraFundB(@Param("cost") Double cost, @Param("rate") Double rate, @Param("year") int yearCount);
}

/*
 * Copyright (C), 2013-2017
 * FileName: DracarysAnnotComponentProvider.java
 * Author:   ZIX
 * Date:     2017年12月13日 上午9:44:50
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.commons.impl.client;

import org.dracarys.commons.annotation.Service;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * 扫描在接口上用自定义注解org.dracarys.commons.annotation.Service.Service.class的接口<br> 
 *
 * @author chenliang
 */
public class AnnotationComponentProvider extends ClassPathScanningCandidateComponentProvider {
    public AnnotationComponentProvider() {
        super(false);
        addIncludeFilter(new AnnotationTypeFilter(Service.class, false));
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }
}

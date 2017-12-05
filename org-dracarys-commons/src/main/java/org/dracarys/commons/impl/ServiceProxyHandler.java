/*
 * Copyright (C), 2013-2017, 上海赛可电子商务有限公司
 * FileName: ServiceProxyHandler.java
 * Author:   chenliang
 * Date:     2017年11月22日 下午5:39:42
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.commons.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import org.dracarys.commons.annotation.EndPoint;
import org.dracarys.commons.annotation.Param;
import org.dracarys.commons.annotation.Service;
import org.dracarys.commons.impl.netty.NettyClient;
import org.dracarys.commons.impl.netty.NettyConsts;
import org.dracarys.commons.util.AnnotationUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.TypeUtils;

/**
 * 服務代理類<br>
 *
 * @author chenliang
 */
public class ServiceProxyHandler implements InvocationHandler {
    public static ArrayBlockingQueue<String> message = new ArrayBlockingQueue<>(1);

    /**
     * 执行目标对象的方法
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        EndPoint endpoint = AnnotationUtil.getAnnotation(method.getAnnotations(), EndPoint.class);
        Service service = AnnotationUtil.getAnnotation(method.getDeclaringClass().getAnnotations(), Service.class);
        if (service != null && endpoint != null) {
            String apiName = service.value() + "." + endpoint.value();
            Annotation[][] annotations = method.getParameterAnnotations();
            Map<String, Object> params = new HashMap<>();
            for (int i = 0; i < args.length; i++) {
                Param param = AnnotationUtil.getAnnotation(annotations[i], Param.class);
                if (param == null)
                    continue;
                params.put(param.value(), args[i]);
            }

            Map<String, Object> request = new HashMap<>();
            request.put("api", apiName);
            request.put("params", params);

            new NettyClient().connect(NettyConsts.PORT, NettyConsts.IP, JSON.toJSONString(request));
            String result = message.take();
            ResponseResult response = JSON.parseObject(result, ResponseResult.class);
            if (response.getStatus() == 1) {
                return parseParam(method.getReturnType(), String.valueOf(response.getMessage()));
            } else {
                throw new RuntimeException(String.valueOf(response.getMessage()));
            }
        } else {
            throw new RuntimeException("can not find EndPoint or Service annotation");
        }
    }

    // 字符串转换成对应类型的参数
    private static Object parseParam(Class<?> type, String paramValue) {
        if (paramValue == null) {
            return null;
        }
        try {
            return TypeUtils.cast(paramValue, type, null);
        } catch (Exception e) {
            return JSON.parseObject(paramValue, type);
        }
    }
}

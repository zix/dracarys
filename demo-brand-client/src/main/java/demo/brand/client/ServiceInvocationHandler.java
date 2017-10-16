package demo.brand.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.TypeUtils;
import demo.brand.meta.EndPoint;
import demo.brand.meta.Param;
import demo.brand.meta.Service;
import demo.brand.utils.AnnotationUtil;
import demo.brand.vo.ResponseResult;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 服务调用处理程序
 *
 * @author v_hebo
 * @create 2017-10-13 11:16
 */
public class ServiceInvocationHandler implements InvocationHandler {

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
				if(param == null)
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
		}else{
			throw new RuntimeException("can not find EndPoint or Service annotation");
		}
	}

	/**
	 * 获取代理对象
	 *
	 * @return 代理对象
	 */
	public static Object getProxy(Class clazz) {
		Class[] classes;
		if (clazz.isInterface()) {
			classes = new Class[]{clazz};
		} else {
			classes = clazz.getInterfaces();
		}
		return getProxy(classes);
	}

	/**
	 * 获取代理对象
	 *
	 * @return 代理对象
	 */
	public static Object getProxy(Class[] classes) {
		return Proxy.newProxyInstance(ServiceInvocationHandler.class.getClassLoader(),
				classes, new ServiceInvocationHandler());
	}

	//字符串转换成对应类型的参数
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

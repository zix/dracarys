package demo.brand.service.server;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;

import demo.brand.meta.EndPoint;
import demo.brand.meta.Service;
import demo.brand.util.AnnotationUtil;
import demo.brand.vo.Brand;
import demo.brand.vo.ResponseResult;

public class ServiceManager {
	public static final TypeReference<Map<String, String>> STRING_MAP = new TypeReference<Map<String, String>>(){};
	private static Map<Class<?>, Object> serviceInstans = new HashMap<Class<?>, Object>();
	private static Map<String, Method> serviceEndpoints = new HashMap<String, Method>();
	public static void init() throws Exception{
		//需要注册的服务
		String[] services = new String[]{"demo.brand.service.impl.BrandServiceImpl", "demo.brand.service.impl.ServerInfoImpl"};
		for (String service : services) {
			Class<?> serviceClass = Class.forName(service);
			Class<?> interfaceClass = serviceClass.getInterfaces()[0];
			//创建服务实例
			serviceInstans.put(interfaceClass, serviceClass.newInstance());
			//注册服务
			String serviceName = (String)AnnotationUtil.getAnnotationValue(interfaceClass, Service.class, "value");
			for (Method m : interfaceClass.getMethods()) {
				String endPointName = (String)AnnotationUtil.getAnnotationValue(m, EndPoint.class, "value");
				serviceEndpoints.put(serviceName + "." + endPointName, m);
			}
		}
	}
	
	public static String doService(String requestStr) {
		System.out.println("---doService START: " + requestStr);
		ResponseResult response = new ResponseResult();
		try {
			Map<String, String> requestInfo = JSON.parseObject(requestStr, STRING_MAP);
			String api = requestInfo.get("api");
			String paramStr = requestInfo.get("params");
			Method endPoint = serviceEndpoints.get(api);
			Object result = endPoint.invoke(serviceInstans.get(endPoint.getDeclaringClass()), resoveParam(endPoint, paramStr));
			response.setMessage(result);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(0);
			if (e instanceof InvocationTargetException) {
				response.setMessage(((InvocationTargetException) e).getTargetException());
			} else {
				response.setMessage(e.getMessage() + (e.getCause()==null?"":e.getCause().getMessage()));
			}
		
		}
		String responseStr = JSON.toJSONString(response, SerializerFeature.WriteDateUseDateFormat);
		System.out.println("---doService END: " + responseStr);
		return responseStr;
	}
	
	//解析参数
	private static Object[] resoveParam(Method m, String paramStr) throws Exception{
		Class<?>[] paramTypes = m.getParameterTypes();
		Annotation[][] paramAnnotations = m.getParameterAnnotations();
		Object[] param = new Object[paramTypes.length];
		if (paramTypes.length > 0) {
			Map<String, String> paramMap = new HashMap<String, String>();
			if (paramStr != null) {
				paramMap = JSON.parseObject(paramStr, STRING_MAP);
			}
			for (int i = 0; i < paramTypes.length; i++) {
				String paramName = (String)AnnotationUtil.getAnnotationValue(paramAnnotations[i][0], "value");
				param[i] = parseParam(paramTypes[i], paramMap.get(paramName));
			}
		}
		return param;
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
	
	public static void main(String[] args) throws Exception{
		//System.out.println(System.getProperties());
		
		ServiceManager.init();
		Map<String, Object> request = new HashMap<String, Object>();
		Map<String, Object> params =  new HashMap<String, Object>();
		request.put("api", "demo.brandService.createBrand");
		request.put("params", params);
		
		params.put("brandInfo", new Brand(null, "别克", "build"));
		params.put("brandId", "222");
		params.put("username", "zzz");
		String requestStr = JSON.toJSONString(request);
		//String requestStr = "{\"api\":\"demo.serverInfo.getServerInfoByPropName\", \"params\":{\"propName\":\"java.vm.vendor\"}}";
		String response = ServiceManager.doService(requestStr);
		System.out.println(response);
		/*System.out.println(ServiceManager.doService(requestStr));
		System.out.println(ServiceManager.doService(requestStr));
		System.out.println(ServiceManager.doService(requestStr));*/
	}
}

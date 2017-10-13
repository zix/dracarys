package demo.brand.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ServiceInvoke {
	private static Map<Class, Object> serviceInstans = new HashMap<Class, Object>();
	private static Map<String, Method> servcieEndpoints = new HashMap<String, Method>();
	public static void init() throws Exception{
		//需要注册的服务
		String[] services = new String[]{"demo.brand.service.impl.BrandServiceImpl", "demo.brand.service.impl.ServerInfoImpl"};
		
		for (String service : services) {
			Class<?> serviceClass = Class.forName(service);
			Class<?> interfaceClass = serviceClass.getInterfaces()[0];
			
			for (Method m : interfaceClass.getMethods()) {
				
			}
			
		}
	}
	
	/*public static Object getAnnotationValue(AnnotatedElement elem, Class annotationClass) {
		Annotation anno = elem.getAnnotation(annotationClass);
		//anno.
	}*/
	
}

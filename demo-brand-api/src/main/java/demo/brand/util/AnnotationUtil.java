package demo.brand.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class AnnotationUtil {
	public static Object getAnnotationValue(AnnotatedElement elem, Class<? extends Annotation> annotationClass, String fieldName) throws Exception{
		Annotation ann = elem.getAnnotation(annotationClass);
		return getAnnotationValue(ann, fieldName);
	}
	
	public static Object getAnnotationValue(Annotation annotation, String fieldName) throws Exception{
		return annotation.annotationType().getMethod(fieldName).invoke(annotation);
	}
}

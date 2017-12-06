package org.dracarys.commons.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;

/**
 * 注解工具类
 *
 * @author v_hebo
 * @create 2017-10-13 11:19
 */
public class AnnotationUtil {
    public AnnotationUtil() {
    }

    public static <T> T getAnnotation(Annotation[] annotaions, Class<? extends Annotation> T) {
        for (int i = 0; i < annotaions.length; ++i) {
            if (annotaions[i].annotationType().equals(T)) {
                return (T) annotaions[i];
            }
        }

        return null;
    }

    public static Class<?> getAnnotatedClass(Class<?>[] classes, Class<? extends Annotation> annotation) {
        for (int i = 0; i < classes.length; ++i) {
            if (classes[i].isAnnotationPresent(annotation)) {
                return classes[i];
            }
        }

        return null;
    }

    public static Class<?>[] getAnnotatedClasses(Class<?>[] classes, Class<? extends Annotation> annotation) {
        ArrayList<Class<?>> annotatedClasses = new ArrayList();

        for (int i = 0; i < classes.length; ++i) {
            if (classes[i].isAnnotationPresent(annotation)) {
                annotatedClasses.add(classes[i]);
            }
        }

        return (Class[]) annotatedClasses.toArray(new Class[0]);
    }
    
    public static Object getAnnotationValue(AnnotatedElement elem, Class<? extends Annotation> annotationClass, String fieldName) throws Exception {
        Annotation ann = elem.getAnnotation(annotationClass);
        return getAnnotationValue(ann, fieldName);
    }

    public static Object getAnnotationValue(Annotation annotation, String fieldName) throws Exception {
        return annotation.annotationType().getMethod(fieldName).invoke(annotation);
    }
}

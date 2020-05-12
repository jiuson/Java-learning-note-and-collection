package com.learning.java.reflect.clazz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: test annotation
 * @Author: jiuson
 * @Date: 2019-08-20 16:51
 * @Version: 1.0
 */

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String[] value() default "a";
}

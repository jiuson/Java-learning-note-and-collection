package com.learning.java.reflect.annotation;/**

/**
 * @program java
 * @author jiuson
 * @create 2019/08/19 22:30
 * @description test object
 */
public class Person {

    @MyAnnotation({"field_abc", "field_def"})
    String name;

    @MyAnnotation({"method_abc", "method_def"})
    public String eat(String param){
        return param;
    }
}

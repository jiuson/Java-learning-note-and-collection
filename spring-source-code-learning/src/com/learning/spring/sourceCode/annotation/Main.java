package com.learning.spring.sourceCode.annotation;

import com.learning.spring.sourceCode.annotation.bean.AbstractService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.learning.spring.sourceCode.annotation");
        ((AbstractService) context.getBean("service1")).method();
    }
}

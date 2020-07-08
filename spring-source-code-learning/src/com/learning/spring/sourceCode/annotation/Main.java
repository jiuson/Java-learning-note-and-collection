package com.learning.spring.sourceCode.annotation;

import com.learning.spring.sourceCode.annotation.bean.AbstractService;
import com.learning.spring.sourceCode.annotation.bean.Component1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.learning.spring.sourceCode.annotation");
        ((AbstractService) context.getBean("service1")).method();
        Component1 component1 = context.getBean(Component1.class);
    }
}

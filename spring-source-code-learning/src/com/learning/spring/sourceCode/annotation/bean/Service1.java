package com.learning.spring.sourceCode.annotation.bean;

import org.springframework.stereotype.Component;

@Component
public class Service1 extends AbstractService {

    public void method() {
        System.out.println("service1");
    }
}

package com.learning.spring.sourceCode.annotation.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public abstract class AbstractService {

    private String serviceName;

    /**
     * 这个方法会在每个子类初始化的时候被多次执行
     */
    @PostConstruct
    public void init() {
        System.out.println("初始化抽象类");
    }

    public abstract void method();
}

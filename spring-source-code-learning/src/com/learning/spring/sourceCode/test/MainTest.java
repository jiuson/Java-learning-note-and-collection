package com.learning.spring.sourceCode.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ProjectName: spring-source-code-learning
 * @Author chali
 * @Description
 * @Date 2020/9/24 4:47 下午
 */
public class MainTest {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(AnnotationConfig.class);
        TestBean testBean = (TestBean) ApplicationContextUtil.getBeanByName("testBean");
        System.out.println(testBean.getName());
    }
}

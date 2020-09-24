package com.learning.spring.sourceCode.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: spring-source-code-learning
 * @Author chali
 * @Description
 * @Date 2020/9/24 4:45 下午
 */

@Configuration
public class AnnotationConfig {

    @Bean
    public TestBean testBean() {
        return new TestBean("aware test");
    }

    @Bean
    public ApplicationContextAwareTest applicationContextAwareTest() {
        return new ApplicationContextAwareTest();
    }
}

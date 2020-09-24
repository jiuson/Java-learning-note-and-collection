package com.learning.spring.sourceCode.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ProjectName: spring-source-code-learning
 * @Author chali
 * @Description
 * @Date 2020/9/24 4:39 下午
 */
public class ApplicationContextAwareTest implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.setApplicationContext(applicationContext);
    }
}

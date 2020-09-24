package com.learning.spring.sourceCode.test;

import org.springframework.context.ApplicationContext;

/**
 * @ProjectName: spring-source-code-learning
 * @Author chali
 * @Description
 * @Date 2020/9/24 4:57 下午
 */
public class ApplicationContextUtil {

    static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static Object getBeanByName(String beanName) {
        return applicationContext.getBean(beanName);
    }
}

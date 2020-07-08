package com.learning.spring.sourceCode.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ProjectName: Java-note
 * @Author chali
 * @Description
 * @Date 2020/7/8 1:09 下午
 */

@Component
public class Component1 {

    @Autowired
    private Map<String, AbstractService> abstractServiceMap;
}

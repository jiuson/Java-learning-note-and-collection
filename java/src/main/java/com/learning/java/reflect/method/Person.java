package com.learning.java.reflect.method;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/23 12:29
 * @description test object
 */
public class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }


    private void eat(String param){
        System.out.println("this is private method eat, param is:" + param);
    }

    public String run(String param){
        System.out.println("this is public method run, param is:" + param);
        return param;
    }
}

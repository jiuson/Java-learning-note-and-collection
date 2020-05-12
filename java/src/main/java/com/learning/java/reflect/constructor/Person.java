package com.learning.java.reflect.constructor;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/23 13:03
 * @description test object person
 */
public class Person {

    private String name;
    private Integer age;

    public Person() {
        System.out.println("this is no parameter constructor");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("this have parameter constructor");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
